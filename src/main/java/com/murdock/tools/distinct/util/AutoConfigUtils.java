/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.murdock.tools.distinct.util;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * @author weipeng 2012-12-13 ����9:47:54
 */
public class AutoConfigUtils {

    /**
     * ʹ��jakarta��configuration������xml���������auto-config.xml
     * 
     * @param file
     * @return
     */
    @SuppressWarnings("unchecked")
    public static final List<String> getAutoConfigKeyNames(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException();
        }

        try {
            Configuration configuration = new XMLConfiguration(file);

            return configuration.getList("group.property[@name]");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
