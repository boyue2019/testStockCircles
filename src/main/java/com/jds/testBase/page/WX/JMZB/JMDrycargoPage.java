package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.PageAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 每日听干货列表
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

    //每日听干货文章列表 【WebView】
    @FindBy(xpath = "//wx-complisten[5]")
    @CacheLookup
    private WebElement articlelist;

    /**
     * 【测试点】判断页面是否包含所有文章类型
     * @return
     */
    public Boolean isIncludeArticleType(){
        Boolean isHave = false;
        this.waitLoading(3);  //等待3秒加载页面
        for (int i =0;i < 3;i++){
            switch (i){
                case 0:
                    Boolean a = PageAction.jumpToWindowHandel(tab_ss);
                    if (a){
                        isHave = a;
                    }else {
                        isHave = false;
                        break;
                    }
                case 1:
                    Boolean b = PageAction.jumpToWindowHandel(tab_wmgtx);
                    if (b){
                        isHave = b;
                    }else {
                        isHave = false;
                        break;
                    }
                case 2:
                    Boolean c = PageAction.jumpToWindowHandel(tab_cjzbc);
                    if (c){
                        isHave = c;
                    }else {
                        isHave = false;
                        break;
                    }
            }
        }
        return isHave;
    }

    /**
     * 【测试点】判断文章列表至少展示11篇文章
     * @return
     */
    public Boolean articleCount(){
        String articleListXpath = "//wx-complisten";   //定义文章列表起始xpath
        int count = 0;

        //从"wx-complisten[1]"开始遍历到[11],验证当前页面至少展示11篇文章
        for (int i = 0;i < 11;i++){
            StringBuilder xpath = new StringBuilder();
            xpath.append(articleListXpath);
            xpath.append("[");
            xpath.append(String.valueOf(i+1));
            xpath.append("]");
            try {
                PageAction.jumpToWindowHandel(Driver.getDriverWX().findElementByXPath(xpath.toString()));  //查找指定位置的文章元素
            }catch (NoSuchElementException n){
                System.out.println("找不到对应元素;【Method】articleCount");
                count = i;
                break;
            }catch (StaleElementReferenceException s){
                System.out.println("页面元素过时;【Method】articleCount");
                count = i;
                break;
            }
            count++;
        }

        //判断文章数量是否满足要求
        if (count == 11){
            System.out.println("文章数量:" + count);
            return true;
        }else {
            System.out.println("文章数量:" + count);
            return false;
        }
    }

    /**
     * 【事件】跳转至"为民观天下"列表
     * 备注:需重新加载页面(new页面对象),否则会报页面元素过时
     * @return
     */
    public JMDrycargoPage skipWMGTX(){
        try{
            tab_wmgtx.click();
            this.waitLoading(3);  //等待3秒加载页面元素
        }catch (NoSuchElementException e){
            System.out.println("找不到对应元素;【Method】skipWMGTX");
        }
        return new JMDrycargoPage();
    }

    /**
     * 【事件】跳转至"财经早班车"列表
     * 备注:需重新加载页面(new页面对象),否则会报页面元素过时
     * @return
     */
    public JMDrycargoPage skipCJZBC(){
        PageAction.switchToWebview();
        try{
            tab_cjzbc.click();
            this.waitLoading(3);  //等待3秒加载页面元素
        }catch (NoSuchElementException e){
            System.out.println("找不到对应元素;【Method】skipCJZBC");
        }
        return new JMDrycargoPage();
    }
}