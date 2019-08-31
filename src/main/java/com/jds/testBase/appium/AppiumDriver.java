package com.jds.testBase.appium;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

public class AppiumDriver {
    /**
     * 启动Appium服务
     * @param port
     * @param bp
     */
    public static void startServer(String port,String bp){
        CommandLine cmd = new CommandLine("/usr/local/bin/node");
        cmd.addArgument("/usr/local/bin/appium");
        cmd.addArgument("-a");
        cmd.addArgument("127.0.0.1");
        cmd.addArgument("-p");
        cmd.addArgument(port);
        cmd.addArgument("-bp");
        cmd.addArgument(bp);

        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);

        try {
            executor.execute(cmd, handler);
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭Appium服务
     */
    public static void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("killall node");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}