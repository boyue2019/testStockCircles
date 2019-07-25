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

    /**
     * 解析STF接口返回的json,筛选可用设备信息并return
     * @return
     */
    public String[][] devicesInfo(){
        Gson gson = new Gson();
        STFService stfService = new STFService();
        STFBean stfBean = gson.fromJson(stfService.STFDevicesList(), STFBean.class);
        List<STFBean.DevicesBean> devices = stfBean.getDevices();
        int sum = devices.size();                                  //总设备数
        int count = 0;                                             //计数器:记录连接状态的设备数
        String[][] devicesList = new String[sum][5];               //定义二维数组 - 5代表设备信息数

        //采集与STF连接且联网的设备信息
        for (int i = 0;i < sum;i++){
            boolean isPresent = devices.get(i).isPresent();        //是否连接
            boolean isConnected = devices.get(i).getNetwork().isConnected();    //是否联网
            if (isPresent && isConnected){                         //STF连接 && 联网
                devicesList[count][0] = devices.get(i).getManufacturer();   //厂商
                devicesList[count][1] = devices.get(i).getModel();          //型号
                devicesList[count][2] = devices.get(i).getSerial();         //设备号
                devicesList[count][3] = devices.get(i).getVersion();        //系统版本
                devicesList[count][4] = devices.get(i).getPlatform();       //Android或iOS
                count+=1;
            }else if(isPresent && !isConnected){
                System.out.println("设备网络异常:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
                //Log4jUtils.logInfo("设备网络异常:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
            }else if(!isPresent){
                System.out.println("设备未连接STF:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
                //Log4jUtils.logInfo("设备未连接STF:" + devices.get(i).getModel() + "<" + devices.get(i).getSerial() + ">");
            }
        }
        this.setLinknum(count);  //记录STF连接设备数
        return devicesList;
    }
}