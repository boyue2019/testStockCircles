package com.jds.testBase.page.Android;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends BasePage {
    //退出登录
    @FindBy(id = "com.jindashi.stockcircle:id/personal_login_out")
    @CacheLookup
    private WebElement login_out;

    //用户昵称
    @FindBy(id = "com.jindashi.stockcircle:id/personal_layon_nickname")
    @CacheLookup
    private WebElement nickname;


    /**
     * 点击退出登录
     */
    @Step("【个人中心】退出登录")
    public MinePage userLoginOut(){
        PageAction.click(10,login_out);
        return new MinePage();
    }

    public boolean findOut(){
        boolean result = PageAction.isElementExist(login_out);
        return result;
    }

    public String getNickname(){
        String nickName = nickname.getText();
        return nickName;
    }
}
