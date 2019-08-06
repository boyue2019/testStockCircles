package com.jds.testBase.yaml;

import com.jds.testBase.util.CommonTools;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelRead {
    /**
     * 读取docker-compose.yaml并返回ModelBean对象
     */
    public ModelBean ReadYaml(){
        ModelBean modelBean = new ModelBean();
        try{
            Yaml yaml = new Yaml();
            File file = new File(System
                    .getProperty("user.dir")
                    + "/config/docker-compose.yaml");
            FileInputStream fileInputStream = new FileInputStream(file);
            modelBean = yaml.loadAs(fileInputStream,ModelBean.class);
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        return modelBean;
    }

    public static void main(String[] args){
        ModelRead read = new ModelRead();
        ModelBean bean = read.ReadYaml();
        Map driverparameter = new HashMap();
        driverparameter.put("port",bean.getModeldetails().get(0).getAppiumParameters().getPort());
        driverparameter.put("udid",bean.getModeldetails().get(0).getSerial());
        driverparameter.put("platformName",bean.getModeldetails().get(0).getSystem());
        driverparameter.put("version",bean.getModeldetails().get(0).getDeviceInfos().getVersion());
        driverparameter.put("ExperimentalOption",CommonTools.getConfigData("ExperimentalOption"));
        System.out.println(driverparameter.get("ExperimentalOption"));
    }
}
