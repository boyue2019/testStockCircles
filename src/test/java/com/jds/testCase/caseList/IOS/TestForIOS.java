package com.jds.testCase.caseList.IOS;

import com.jds.testBase.driver.Driver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestForIOS {
    @Test
    public void testCase1(){
        System.out.println("IOS自动化测试_Case1");
    }

    @Test
    public void testCase2(){
        System.out.println("IOS自动化测试_Case2");
    }

    @Parameters({"port","udid"})
    @Test
    public void testCase3(String port,String udid) throws Exception{
        Driver.startIOS(port,udid);
        System.out.println("IOS执行成功!");
    }
}
