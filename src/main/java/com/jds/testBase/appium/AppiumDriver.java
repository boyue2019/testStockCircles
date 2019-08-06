package com.jds.testBase.appium;

import com.jds.testBase.util.CommonTools;
import com.jds.testBase.yaml.ModelBean;
import com.jds.testBase.yaml.ModelRead;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumDriver {
    private AppiumDriverLocalService service;

    /**
     * 启动Appium服务
     *   - 域名从config.properties配置文件中获取
     *   - port从生成对yaml文件中获取
     */
    public void startServer(){
        ModelRead read = new ModelRead();
        ModelBean bean = read.ReadYaml();
        String port = bean.getModeldetails().get(0).getAppiumParameters().getPort();   //获取appium端口
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress(CommonTools.getConfigData("AppiumServerUrl"));            //添加启动
        builder.usingPort(Integer.parseInt(port));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        service = AppiumDriverLocalService.buildService(builder);
        System.out.println("启动Appium服务.");
        if (!service.isRunning()){
            service.start();     //启动服务
        }
        else {
            System.out.println("Appium已启用.");
        }
    }

    /**
     * 关闭Appium服务
     */
    public void stopServer(){
        if (service.isRunning()){
            service.stop();
        }else {
            System.out.println("Appium服务未启用.");
        }
    }
}