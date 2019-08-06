package com.jds.testBase.yaml;

import com.jds.testBase.stf.STFDevices;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private int port;   //appium监听端口

    /**
     * 过滤二维数组中空值并设置设备对应port和bp端口号
     * @return
     */
    public String[][] ModelSource(){
        port = 4723;
        STFDevices stfDevices = new STFDevices();
        String[][] devicesInfo = stfDevices.devicesInfo();
        int size = stfDevices.getLinknum();  //连接设备数==循环次数
        String[][] imageModel = new String[size][7];
        for (int i = 0;i < size;i++){
            imageModel[i][0] = devicesInfo[i][0];       //厂商
            imageModel[i][1] = devicesInfo[i][1];       //型号
            imageModel[i][2] = devicesInfo[i][2];       //设备号
            imageModel[i][3] = devicesInfo[i][3];       //系统版本
            imageModel[i][4] = String.valueOf(port);    //port
            imageModel[i][5] = String.valueOf(port+1);  //bp端口
            imageModel[i][6] = devicesInfo[i][4];       //设备系统:Android或iOS
            port+=2;
        }
        return imageModel;
    }

    /**
     * Yaml模版
     * @param source 获取STF设备信息(二维数组)
     */
    public ModelBean Model(String[][] source){
        int size = source.length;  //根据数组长度定义循环次数
        ModelBean modelBean = new ModelBean();
        List<ModelBean.ServiceDetails> serviceDetailsList = new ArrayList<>();

        for(int i = 0;i < size;i++){
            ModelBean.ServiceDetails serviceDetails = new ModelBean.ServiceDetails();
            ModelBean.ServiceDetails
                    .DeviceInfo deviceInfo = new ModelBean
                    .ServiceDetails
                    .DeviceInfo();
            ModelBean.ServiceDetails
                    .AppiumParameter appiumParameter = new ModelBean
                    .ServiceDetails
                    .AppiumParameter();
            ModelBean.ServiceDetails
                    .DockerParameter dockerParameter = new ModelBean
                    .ServiceDetails
                    .DockerParameter();
            // 添加设备信息
            deviceInfo.setManufacturer(source[i][0]);
            deviceInfo.setModel(source[i][1]);
            deviceInfo.setSerial(source[i][2]);
            deviceInfo.setVersion(source[i][3]);
            serviceDetails.setDeviceInfos(deviceInfo);
            serviceDetails.setSerial(source[i][2]);
            serviceDetails.setSystem(source[i][6]);
            // 添加Appium参数
            appiumParameter.setPort(source[i][4]);
            appiumParameter.setBp(source[i][5]);
            serviceDetails.setAppiumParameters(appiumParameter);
            // 添加Docker镜像参数
            dockerParameter.setImage("");
            dockerParameter.setContainerName("");
            serviceDetails.setDockerParameters(dockerParameter);

            serviceDetailsList.add(serviceDetails);
        }
        modelBean.setModeldetails(serviceDetailsList);
        return modelBean;
    }

    /**
     * 创建Yaml模版
     */
    public void MakeModel(){
        ModelBean modelBean = this.Model(this.ModelSource());
        try{
            Yaml yaml = new Yaml();
            File file = new File(System.getProperty("user.dir") + "/config/docker-compose.yaml");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(yaml.dump(modelBean));
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ModelFactory modelFactory = new ModelFactory();
        modelFactory.MakeModel();
    }
}