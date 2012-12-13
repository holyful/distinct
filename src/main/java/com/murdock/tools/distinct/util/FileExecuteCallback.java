/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.murdock.tools.distinct.util;

import java.io.File;

/**
 * @author weipeng 2012-12-3 ����3:46:48
 */
public interface FileExecuteCallback {

    /**
     * ����ǰ���ļ�
     * 
     * @param file
     */
    void handle(File file);
}
