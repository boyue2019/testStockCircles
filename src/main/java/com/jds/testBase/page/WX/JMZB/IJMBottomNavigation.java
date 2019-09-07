package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import io.qameta.allure.Step;

public interface IJMBottomNavigation {
    /**
     * 点击底部导航:首页
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'首页'")
    default JMHomePage goToHomePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(15,JMBottomNavigationPage.home);
        return new JMHomePage();
    }

    /**
     * 点击底部导航:微课
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'微课'")
    default JMWeiKePage goToWeiKePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(15,JMBottomNavigationPage.WeiKe);
        return new JMWeiKePage();
    }

    /**
     * 点击底部导航:我的
     * context:NATIVE_APP
     * @return
     */
    @Step("【底部导航】点击进入'我的'")
    default JMMinePage goToMinePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(15,JMBottomNavigationPage.mine);
        return new JMMinePage();
    }
}
