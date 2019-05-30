package com.jds.testCase.caseList.Android;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.page.Android.HomePage;
import com.jds.testBase.page.Android.LoginPage;
import com.jds.testBase.page.Android.MinePage;
import com.jds.testBase.util.Android.PageAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseCase {
    static HomePage homePage;
    static MinePage minePage;
    static LoginPage loginPage;

    @BeforeSuite(description = "创建截图及日志目录")
    public void creatPath(){
        Driver.createSavePath();
    }

    @Parameters({"port","udid"})
    @BeforeClass(description = "启动APP")
    public void goToHome(String port,String udid) throws Exception{
        homePage = PageAction.startAPP(port, udid);
    }
}
