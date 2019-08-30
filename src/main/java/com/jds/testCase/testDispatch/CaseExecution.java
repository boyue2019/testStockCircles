package com.jds.testCase.testDispatch;

import com.jds.testBase.appium.AppiumDriver;
import com.jds.testBase.yaml.ModelRead;
import org.testng.TestNG;

import java.util.List;
import java.util.Map;

/**
 * 根据设备信息生成testNG.XML并执行用例
 */
public class CaseExecution {
    public void run(){
        /**
        //通过STF获取设备信息并生成yaml文件
        ModelFactory modelFactory = new ModelFactory();
        modelFactory.MakeModel();     //采集设备信息并生成yaml文件
         */

        //从yaml文件读取设备信息
        ModelRead read = new ModelRead();
        List<Map> deviceslist = read.DevicesDetails();
        int number = deviceslist.size();  //获取数量

        //启动Appium服务
        for (int i = 0;i < number;i++){
            System.out.println(i);
            AppiumDriver.startServer(deviceslist.get(i).get("port").toString(),deviceslist.get(i).get("bp").toString());
        }

        //生成TestNG.XML
        Dispatcher dispatcher = new Dispatcher();
        TestNG testNG = dispatcher.TestNGXML(deviceslist);

        //AppiumDriver.startServer();
        testNG.run();
    }

    public static void main(String[] args){
        CaseExecution execution = new CaseExecution();
        execution.run();
    }
}
