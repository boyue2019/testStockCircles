package com.jds.testBase.page.Android;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MinePage extends BasePage implements IBottomNavigation{
    /**
     * 页面元素
     * @FindBy 定义元素
     * @CacheLookup 缓存固定元素
     */
    @FindBy(id = "com.jindashi.stockcircle:id/rl_mine_login")
    @CacheLookup
    private WebElement login;  //"用户登录"入口

    /**
     * 进入登录页面
     * @return
     */
    @Step("【我的】点击进入用户登录页")
    public LoginPage goToLoginPage(){
        PageAction.click(5,login);
        return new LoginPage();
    }

    /**
     * 等待元素出现后截图 - 登录入口
     */
    @Step("【我的】截图")
    public void minePageScreenshot(){
        PageAction.waitElementScreenshot(10,login);
    }
}
