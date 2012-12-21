package com.murdock.tools.distinct.db.redis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.murdock.tools.distinct.db.MatchDB;

/**
 * <pre>
 * ʹ����Spring��aop������Ѿ�û�б�Ҫ��
 * 
 * </pre>
 * 
 * @author weipeng 2012-12-6 ����4:42:22
 */
public class GetAndReleaseHandler implements InvocationHandler {

    private MatchDB matchDB = new MatchDBImpl();

    /*
     * (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            result = method.invoke(matchDB, args);
        } finally {
            // �����ͷ�����
            JedisPool.getPool().releaseConnection();
        }
        return result;
    }

}
