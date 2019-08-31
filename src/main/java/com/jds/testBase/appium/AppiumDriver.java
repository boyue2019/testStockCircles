package com.jds.testBase.appium;

import java.io.IOException;

public class AppiumDriver {
    /**
     * 启动Appium服务
     *   - 域名从config.properties配置文件中获取
     *   - port从生成对yaml文件中获取
     */
    public static void startServer(String port,String bp){
        String cmd = "appium -a 127.0.0.1 -p " + port + " -bp " + bp;
        Runtime runtime = Runtime.getRuntime();


        try{
            runtime.exec(cmd);
        }catch (IOException I){

        }

        /**
        String cmd = "appium -a 127.0.0.1 -p " + port + " -bp " + bp;
        Process p;
        try{
                p = Runtime.getRuntime().exec(cmd);
            System.out.println("启动Appium:");
            System.out.println("port:" + port + "  bp:" + bp);
            p.waitFor();
        }catch (IOException E){
            System.out.println("Appium启动异常.");
        }catch (InterruptedException I){

        }
         */
    }

    public static void main(String[] args){
        AppiumDriver.startServer("4723","4724");
    }
}