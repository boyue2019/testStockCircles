package com.jds.testBase.stf;

import com.google.gson.Gson;
import com.jds.testBase.log.Log4jUtils;

import java.util.List;

/**
 * 获取所需设备信息
 * 1. 状态：与STF连接、已连接网络
 * 2. 返回信息：manufacturer|model|serial|version
 * 3. 返回二维数组中包含null
 */
public class STFDevices {
    private int linknum;   //与STF连接设备数

    public void setLinknum(int linknum) {
        this.linknum = linknum;
    }

    public int getLinknum() {
        return linknum;
    }

    public String[][] devicesInfo(){
        Gson gson = new Gson();
        STFService stfService = new STFService();
        STFBean stfBean = gson.fromJson(stfService.STFDevicesList(), STFBean.class);
        List<STFBean.DevicesBean> devices = stfBean.getDevices();
        int sum = devices.size();                                  //总设备数
        int count = 0;                                             //连接数:计数器
        String[][] devicesList = new String[sum][4];               //定义二维数组 - 4代表设备信息数

        //采集与STF连接且联网的设备信息
        for (int i = 0;i < sum;i++){
            boolean isPresent = devices.get(i).isPresent();
            boolean isConnected = devices.get(i).getNetwork().isConnected();
            if (isPresent && isConnected){                         //STF连接 && 联网
                devicesList[i][0] = devices.get(i).getManufacturer();   //厂商
                devicesList[i][1] = devices.get(i).getModel();          //型号
                devicesList[i][2] = devices.get(i).getSerial();         //设备号
                devicesList[i][3] = devices.get(i).getVersion();        //Android版本
                count+=1;
            }else if(isPresent && !isConnected){
                Log4jUtils.logInfo("设备网络异常:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
            }else if(!isPresent){
                Log4jUtils.logInfo("设备未连接STF:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
            }
        }
        this.setLinknum(count);  //记录STF连接设备数
        return devicesList;
    }

    public static void main(String[] args){
        STFDevices stfDevices = new STFDevices();
        String[][] a = stfDevices.devicesInfo();
        int size = a.length;
        for (int i = 0;i < size;i++){
            System.out.println("【设备" + (i+1) + "】");
            System.out.println("厂商:" + a[i][0]);
            System.out.println("型号:" + a[i][1]);
            System.out.println("设备号:" + a[i][2]);
            System.out.println("系统版本:" + a[i][3]);
        }
        System.out.println(stfDevices.getLinknum());
    }
}