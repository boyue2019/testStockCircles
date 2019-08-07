package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 每日听干货查看全部页面
 */
public class JMDrycargoPage extends BasePage {
    //每日听干货-师说Tab 【WebView】
    @FindBy(xpath = "//wx-view[@class='category_item']/wx-text[1][span[2]='师说']")
    @CacheLookup
    private WebElement tab_ss;

    //每日听干货-为民观天下Tab 【WebView】
    @FindBy(xpath = "//wx-view[@class='category_item']/wx-text[1][span[2]='为民观天下']")
    @CacheLookup
    private WebElement tab_wmgtx;

    //每日听干货-财经早班车Tab 【WebView】
    @FindBy(xpath = "//wx-view[@class='category_item']/wx-text[1][span[2]='财经早班车']")
    @CacheLookup
    private WebElement tab_cjzbc;

    /**
     * 【测试点】判断页面是否包含文章类型元素
     * @return
     */
    public Boolean isIncludeArticleType(){
        this.waitLoading(3);  //等待3秒加载页面
        Boolean isHave = PageAction.jumpToWindowHandel(tab_ss);
        return isHave;
    }
}