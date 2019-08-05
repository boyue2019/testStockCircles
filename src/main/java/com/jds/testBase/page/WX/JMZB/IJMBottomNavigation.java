package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Step;

public interface IJMBottomNavigation {
    /**
     * 点击底部导航:首页
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'首页'")
    default JMHomePage goToHomePage(){
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.switchToNative();
        PageAction.click(10,JMBottomNavigationPage.home,"wx");
        return new JMHomePage();
    }

    /**
     * 点击底部导航:首页
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'微课'")
    default JMWeiKePage goToWeiKePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(10,JMBottomNavigationPage.WeiKe,"wx");
        return new JMWeiKePage();
    }

    /**
     * 点击底部导航:首页
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'我的'")
    default JMMinePage goToMinePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(10,JMBottomNavigationPage.mine,"wx");
        return new JMMinePage();
    }
}
