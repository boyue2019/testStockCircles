package com.jds.testBase.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtils {
     private static Logger logger(){
        Logger logger = Logger.getLogger(Log4jUtils.class);
        BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/config/log4j.properties");
        return logger;
    }

    /**
     * DEBUG
     * @param logContent
     */
    public static void logDebug(String logContent){
        logger().debug(logContent);
    }

    /**
     * INFO
     * @param logContent
     */
    public static void logInfo(String logContent){
        logger().info(logContent);
    }

    /**
     * WARN
     * @param logContent
     */
    public static void logWarn(String logContent){
        logger().warn(logContent);
    }

    /**
     * ERROR
     * @param logContent
     */
    public static void logError(String logContent){
        logger().error(logContent);
    }

    /**
     * FATAL
     * @param logContent
     */
    public static void LogFatal(String logContent){
        logger().fatal(logContent);
    }
}
