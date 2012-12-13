/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.murdock.tools.distinct.util;

import java.io.File;

/**
 * <pre>
 * �ļ��ݹ鹤��
 * 
 * </pre>
 * 
 * @author weipeng 2012-12-3 ����3:45:05
 */
public final class FileRecursionUtils {

    /**
     * <pre>
     * �ݹ�fileĿ¼�µ��ļ�
     * 
     * </pre>
     * 
     * @param file
     * @param callback
     */
    public static final void recursion(File file, FileExecuteCallback callback) {
        if (file.isFile()) {
            callback.handle(file);
        } else {
            for (File aFile : file.listFiles()) {
                recursion(aFile, callback);
            }
        }
    }
}
