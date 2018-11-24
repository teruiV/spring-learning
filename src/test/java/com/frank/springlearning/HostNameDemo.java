package com.frank.springlearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

/**
 * @author jianweilin
 * @date 2018/10/29
 */
public class HostNameDemo {

    public static String getHostName() throws IOException, InterruptedException {
        Process pro = Runtime.getRuntime().exec("hostname");
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        return read.readLine();
    }

    public static String getPid(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.split("@")[0];
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("PID = " + getPid());
    }
}
