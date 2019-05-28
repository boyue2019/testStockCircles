package com.jds.testBase.page.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 页面：底部导航栏
 * 说明：1.提供页面元素
 *      2.继承BasePage初始化PageFactory
 */
public class BottomNavigationPage extends BasePage{
    /**
     * @FindBy 定义元素
     * @CacheLookup 缓存固定元素
     */
    @FindBy(id = "com.jindashi.stockcircle:id/home_tab_mineTxt")
    @CacheLookup
    static WebElement mineTab;  //底导"我的"标签
}
