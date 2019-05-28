package com.jds.testCase.caseList.Android;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.page.Android.HomePage;
import com.jds.testBase.page.Android.LoginPage;
import com.jds.testBase.page.Android.MinePage;
import com.jds.testBase.util.Android.PageAction;
import com.jds.testCase.caseRule.rule.RGroupName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestForAndroid {
    static HomePage homePage;
    static MinePage minePage;
    static LoginPage loginPage;

    @BeforeTest
    public void creatPath(){
        Driver.createSavePath();
    }

    @Parameters({"port","udid"})
    @BeforeMethod
    public void preparation(String port,String udid) throws Exception{
        homePage = PageAction.startAPP(port, udid);
        //Thread.sleep(5000);
    }

    @Test(groups = {RGroupName.FT,RGroupName.RT})
    public void testCase1() throws Exception{
        minePage = homePage.goToMinePage();
        minePage.minePageScreenshot();
        loginPage = minePage.goToLoginPage();
        PageAction.closeApp();
    }
}
