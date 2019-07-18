package com.jds.testBase.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonTools {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 从config.properties配置文件获取key对应value
     * @param key
     * @return
     */
    public String getConfigData(String key){
        try{
            Properties pFile = new Properties();
            pFile.load(new FileInputStream("/Users/boyue/工作/StockCircles/src/config.properties"));
            String value =  pFile.getProperty(key);
            this.setValue(value);
        }catch (FileNotFoundException f){ }
        catch (IOException I){ }
        return this.getValue();
    }
}
