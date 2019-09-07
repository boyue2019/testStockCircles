package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.PageAction;
import com.jds.testCase.caseList.WX.BaseCase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 每日听干货列表
 */
public class JMDrycargoPage extends BasePage {
    //每日听干货-师说Tab
    @FindBy(xpath = "//wx-view[@id='category_tab0']/wx-text")
    @CacheLookup
    private WebElement tab_ss;

    //每日听干货-为民观天下Tab
    @FindBy(xpath = "//wx-view[@id='category_tab1']/wx-text")
    @CacheLookup
    private WebElement tab_wmgtx;

    //每日听干货-财经早班车Tab
    @FindBy(xpath = "//wx-view[@id='category_tab2']/wx-text")
    @CacheLookup
    private WebElement tab_cjzbc;

    /**
     * 【事件】跳转至"为民观天下"列表
     * 备注:需重新加载页面(new页面对象),否则会报页面元素过时
     * @return
     */
    public JMDrycargoPage skipWMGTX(){
        try{
            tab_wmgtx.click();
            this.waitLoading(2);  //等待3秒加载页面元素
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:tab_wmgtx");
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
            this.waitLoading(2);  //等待3秒加载页面元素
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:tab_cjzbc");
        }
        return new JMDrycargoPage();
    }

    /**
     * 【事件】切换至包含当前页面元素WindowHandel
     */
    public void jumpDrycargoWindowHandel(){
        PageAction.jumpToWindowHandel(tab_ss);  //切换至存在'每日干后-查看全部'的WindowHandel
    }

    /**
     * 【测试点】检查每日听干货列表师说tab是否成功加载
     * @return
     */
    public Boolean isHaveDrycargoTabSS(){
        try{
            return tab_ss.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:tab_tab_sscjzbc");
            return false;
        }
    }

    /**
     * 【测试点】检查每日听干货列表为民观天下tab是否成功加载
     * @return
     */
    public Boolean isHaveDrycargoTabWmgtx(){
        try{
            return tab_wmgtx.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:tab_wmgtx");
            return false;
        }
    }

    /**
     * 【测试点】检查每日听干货列表财经早班车tab是否成功加载
     * @return
     */
    public Boolean isHaveDrycargoTabCjzbc(){
        try{
            return tab_cjzbc.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:tab_cjzbc");
            return false;
        }
    }

    /**
     * 【测试点】检查文章列表至少展示11篇文章
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
                PageAction.jumpToWindowHandel(BaseCase.ThreadDriver.get().getDriverWX().findElementByXPath(xpath.toString()));  //查找指定位置的文章元素
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
}