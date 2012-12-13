/*
 * Copyright 1999-2004 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.murdock.tools.distinct.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author weipeng 2012-12-12 ����2:04:50
 */
public class NetworkUtils {

    /**
     * pingһ��
     * 
     * @param domain
     * @param port
     * @return
     */
    public static final boolean ping(String domain, int port) {
        boolean result = false;
        Socket socket = null;
        try {
            socket = new Socket(domain, port);
            result = true;
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception ex) {

                }
            }
        }

        return result;
    }

    /**
     * ���Ի�ȡһ��domain�µ���Դ������http1.0Э�鳢�Զ�ȡ���� ��Ȼ��������ص���500ϵ�е��쳣����ô�������ȡ����
     * 
     * @param domain
     * @param resource
     * @param port
     * @return
     */
    public static final List<String> readHttpContent(String domain, String resource, int port) {
        Socket socket = null;
        try {
            socket = new Socket(domain, port);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            StringBuilder send = new StringBuilder();
            send.append("GET " + resource + " HTTP/1.0").append("\n");
            send.append("Accept: text/html").append("\n");
            send.append("\n");
            out.write(send.toString());
            out.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            List<String> result = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                if (line.contains("HTTP/1.1 5")) {
                    return Collections.emptyList();
                }

                result.add(line);
            }

            return result;
        } catch (Exception ex) {
            return Collections.emptyList();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception ex) {

                }
            }
        }
    }
}
