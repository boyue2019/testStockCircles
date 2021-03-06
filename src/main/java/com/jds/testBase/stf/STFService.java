package com.jds.testBase.stf;

import com.jds.testBase.util.CommonTools;

import java.io.*;

/**
 * 通过STF_API获取设备信息(json)
 */
public class STFService {
    private String stfUrl;
    private String authToken;

    public void setStfUrl(String stfUrl) {
        this.stfUrl = stfUrl;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getStfUrl() {
        return stfUrl;
    }

    public String getAuthToken() {
        return authToken;
    }

    //从config.properties配置文件中获取STF地址和密钥
    public void getSTFConfig(){
        this.setStfUrl(CommonTools.getConfigData("stfUrl"));
        this.setAuthToken(CommonTools.getConfigData("authToken"));
    }

    //获取设备信息json
    public String STFDevicesList(){
        try {
            this.getSTFConfig();
            String[] allDevices = {"curl",
                    "-H",
                    "Authorization: Bearer " + getAuthToken(),
                    getStfUrl() + "/api/v1/devices"};
            ProcessBuilder processBuilder = new ProcessBuilder(allDevices);
            Process p;
            p = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();
        }catch (Exception e){
            System.out.println("STF设备获取失败!");
        }
        return null;
    }
}
