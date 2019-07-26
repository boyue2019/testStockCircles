package com.jds.testBase.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
                    + "/docker-compose.yaml");
            FileInputStream fileInputStream = new FileInputStream(file);
            modelBean = yaml.loadAs(fileInputStream,ModelBean.class);
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        return modelBean;
    }

    public static void main(String[] args){
        ModelRead modelRead = new ModelRead();
        ModelBean modelBean = modelRead.ReadYaml();
        for(int i = 0;i < 2;i++){
            System.out.println(modelBean.getModeldetails().get(i).getSerial());
        }

    }
}