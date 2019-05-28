package com.jds.testBase.page.Android;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Step;

/**
 * 接口说明：
 * 提供底部导航栏操作功能
 */
public interface IBottomNavigation {
    /**
     * 点击进入"我的"
     * @return
     */
    @Step("【底部导航】点击进入'我的'")
    default MinePage goToMinePage(){
        BottomNavigationPage bottomNavigationPage = new BottomNavigationPage();
        PageAction.click(10,BottomNavigationPage.mineTab);
        return new MinePage();
    }
}
