package com.jds.testBase.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 公共工具类
 */
public class CommonTools {
    private static CommonTools commonTools;
    private static Date date;
    private static Properties properties;

    public static CommonTools getCommonTools() {
        return CommonTools.commonTools;
    }

    public static Date getDate() {
        return CommonTools.date;
    }

    public static Properties getProperties() {
        return CommonTools.properties;
    }

    static {
        commonTools = new CommonTools();
        date = new Date();
        properties = new Properties();
    }

    private CommonTools(){};

    /**
     * 从config.properties配置文件获取key对应value
     * @param key
     * @return
     */
    public static String getConfigData(String key){
        try{
            CommonTools.properties.load(new FileInputStream(System.getProperty("user.dir") + "/config/config.properties"));
            String value =  CommonTools.properties.getProperty(key);
            return value;
        }catch (FileNotFoundException f){
            System.out.println("找不到文件;【Method】getConfigData");
        }
        catch (IOException I){
            System.out.println("读取文件失败;【Method】getConfigData");
        }
        return null;
    }

    /**
     * 创建截图、日志目录
     */
    public static void createSavePath(){
        SimpleDateFormat datePath = new SimpleDateFormat("yyyy-MM-dd");
        String datePathName = datePath.format(CommonTools.getDate().getTime());       //获取日期
        SimpleDateFormat timePath = new SimpleDateFormat("HH_mm_ss");
        String timePathName = timePath.format(CommonTools.getDate().getTime());       //获取时间
        SimpleDateFormat fileName = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String logName = fileName.format(CommonTools.getDate().getTime());            //获取精确时间

        //创建截图目录：文件夹名称为当天日期
        File savePicPath = new File("/Users/boyue/工作/StockCircles/ScreenShot/" + datePathName + "/" + timePathName + "/");
        if(!savePicPath.exists()){
            savePicPath.mkdirs();  //不存在则创建当日文件夹
            System.setProperty("savePicPath",savePicPath.toString());  //设置截图保存路径
        }else {
        }

        //创建日志目录：文件夹名称为当天日期
        File saveLogPath = new File("/Users/boyue/工作/StockCircles/Log/" + datePathName + "/" + timePathName + "/");
        File filelogPath = new File(  "Log/" + datePathName + "/" + timePathName + "/" + logName);
        if(!saveLogPath.exists()){
            saveLogPath.mkdirs();  //不存在则创建当日文件夹
            System.setProperty("logPath",filelogPath.toString());  //设置日志文件名称
        }else {
        }
    }
}
