package com.jds.testBase.yaml;

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

    /**
     * 读取设备信息并以Map数组形式返回
     * @return
     */
    public List<Map> DevicesDetails(){
        List<Map> devicelist = new ArrayList<>();
        ModelBean bean = this.ReadYaml();
        int count = bean.getModeldetails().size();
        for(int i=0;i<count;i++){
            Map<String,String> map = new HashMap<>();
            map.put("port",bean.getModeldetails().get(i).getAppiumParameters().getPort());
            map.put("bp",bean.getModeldetails().get(i).getAppiumParameters().getBp());
            map.put("chromedrniverport",bean.getModeldetails().get(i).getAppiumParameters().getChromedrniverport());
            map.put("system",bean.getModeldetails().get(i).getSystem());
            map.put("serial",bean.getModeldetails().get(i).getSerial());
            map.put("height",bean.getModeldetails().get(i).getDeviceInfos().getHeight());
            map.put("width",bean.getModeldetails().get(i).getDeviceInfos().getWidth());
            map.put("manufacturer",bean.getModeldetails().get(i).getDeviceInfos().getManufacturer());
            map.put("model",bean.getModeldetails().get(i).getDeviceInfos().getModel());
            map.put("version",bean.getModeldetails().get(i).getDeviceInfos().getVersion());
            devicelist.add(map);
        }
        return devicelist;
    }

    public static void main(String[] args){
        ModelRead read = new ModelRead();
        System.out.println(read.DevicesDetails().get(0).get("model"));
        System.out.println(read.DevicesDetails().get(1).get("model"));

    }
}
