/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.murdock.tools.distinct.db;

import java.util.List;

/**
 * @author weipeng 2012-12-6 ����3:59:54
 */
public interface MatchDB {

    /**
     * ����һ����¼
     * 
     * @param row
     * @return
     */
    boolean insert(String row);

    /**
     * ����key value
     * 
     * @param row
     * @param value
     * @return
     */
    boolean insert(String row, String value);

    /**
     * @param jedis
     */
    void addProject(String projectName);

    /**
     * @param jedis
     * @return
     */
    List<String> getProjectNames();

    /**
     * <pre>
     * ƥ���ַ��������ض��ٸ�
     * 
     * </pre>
     * 
     * @param sample
     * @return
     */
    int match(String sample);

    /**
     * �����û�
     * 
     * @return
     */
    int onlineUsers();

    /**
     * <pre>
     * ���DB
     * 
     * </pre>
     * 
     * @return
     */
    boolean clean();

    /**
     * ��ǰ��key����
     * 
     * @return
     */
    long dbsize();

}
