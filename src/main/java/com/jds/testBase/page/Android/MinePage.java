package com.jds.testBase.page.Android;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MinePage extends BasePage implements IBottomNavigation{
    //登录入口
    @FindBy(id = "com.jindashi.stockcircle:id/rl_mine_login")
    @CacheLookup
        private WebElement userLogin;

    //登录状态:用户昵称
    @FindBy(id = "com.jindashi.stockcircle:id/tv_mine_user_name")
    @CacheLookup
    private WebElement userName;

    //登录状态:手机号
    @FindBy(id = "com.jindashi.stockcircle:id/tv_mine_user_phone")
    @CacheLookup
    private WebElement myPhone;

    //游客状态:登录/注册
    @FindBy(id = "com.jindashi.stockcircle:id/mine_unlogin_txt")
    @CacheLookup
    private WebElement unLogin;

    /**
     * 判断是否登录状态
     * 登录状态:返回true 游客状态:返回false
     * @return
     */
    public boolean isLogin(){
        PageAction.waitElement(10,userLogin,"app");  //等待登录信息出现
        boolean islogin = PageAction.isElementExist(userName);  //若包含userName元素则为登录状态
        if (islogin){
            System.out.println("当前状态:登录");
            return true;
        }else {
            System.out.println("当前状态:游客");
            return false;
        }
    }

    /**
     * 若登录状态,跳转至个人中心
     * @return
     */
    @Step("我的】点击进入个人中心")
    public PersonalPage gotoPersonalPage(){
        PageAction.click(5,userLogin,"app");
        return new PersonalPage();
    }

    /**
     * 若游客状态,跳转至登录页面
     * @return
     */
    @Step("【我的】点击进入登录页面")
    public LoginPage goToLoginPage(){
        PageAction.click(5,userLogin,"app");
        return new LoginPage();
    }

    /**
     * 截图
     */
    @Step("【我的】截图")
    @Attachment(value = "我的页面截图:",type = "image/jpg")
    public byte[] minePageScreenshot(){
        return PageAction.screenshot();
    }
}
