package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * 解码直播小程序首页
 */
public class JMHomePage extends BasePage implements IJMBottomNavigation{
    //每日直播 - title
    @FindBy(id = "home_dailylive_title")
    @CacheLookup
    private WebElement home_dailylive_title;

    //每日直播 - 查看全部
    @FindBy(id = "home_dailylive_checkall")
    @CacheLookup
    private WebElement home_dailylive_checkall;

    //每日直播 - 入口
    @FindBy(id = "home_dailylive_enter")
    @CacheLookup
    private WebElement home_dailylive_enter;

    //每日直播 - 栏目名称
    @FindBy(xpath = "//wx-button[@id='home_dailylive_enter']/wx-view/wx-view[2]/wx-view[1]/wx-view[1]")
    @CacheLookup
    private WebElement home_dailylive_name;

    //每日直播 - 在线人数
    @FindBy(xpath = "//wx-button[@id='home_dailylive_enter']/wx-view/wx-view[2]/wx-view[1]/wx-view[2]")
    @CacheLookup
    private WebElement home_dailylive_person;

    //每日干货 - title
    @FindBy(id = "home_drycargo_title")
    @CacheLookup
    private WebElement home_drycargo_title;

    //每日干货 - 查看全部
    @FindBy(id = "home_drycargo_checkall")
    @CacheLookup
    private WebElement home_drycargo_checkall;

    //每日干货 - 文章列表
    @FindBy(id = "home_drycargo_list")
    @CacheLookup
    private WebElement home_drycargo_list;

    //每日干货 - 第一篇文章的主题
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[1]/wx-view/wx-form/span/wx-button/wx-view/wx-view[2]/wx-view/wx-text[1]/span[2]")
    @CacheLookup
    private WebElement home_drycargo_articletitle;

    //每日干货 - 第一篇文章的日期
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[1]/wx-view/wx-form/span/wx-button/wx-view/wx-view[2]/wx-view/wx-text[2]/span[2]")
    @CacheLookup
    private WebElement home_drycargo_articledate;

    //每日干货 - 第一篇文章的入口
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[1]/wx-view/wx-form/span/wx-button")
    @CacheLookup
    private WebElement home_drycargo_enter1;

    //每日干货 - 第一篇文章的入口
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[2]/wx-view/wx-form/span/wx-button")
    @CacheLookup
    private WebElement home_drycargo_enter2;

    //每日干货 - 第一篇文章的入口
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[3]/wx-view/wx-form/span/wx-button")
    @CacheLookup
    private WebElement home_drycargo_enter3;

    //明日投资看点 - 区域top
    @FindBy(xpath = "//wx-view[@id='home_video'][1]")
    @CacheLookup
    private WebElement home_video_mr;

    //明日投资看点 - 区域top
    @FindBy(xpath = "//wx-view[@id='home_video'][2]")
    @CacheLookup
    private WebElement home_video_tz;

    /**
     * 【事件】切换至包含元素当WindowHandel
     */
    public void jumpHomeWindowHandel(){
        this.waitBottomElement();   //等待元素出现
        PageAction.switchToWebview();
        PageAction.jumpToWindowHandel(home_drycargo_checkall);  //切换至存在'每日干后-查看全部'的WindowHandel
    }

    /**
     * 【事件】跳转至每日干货查看全部
     * context:WEBVIEW_com.tencent.mm:appbrand0
     * @return
     */
    public JMDrycargoPage gotoJMDrycargoCheckAll(){
        PageAction.switchToWebview();
        PageAction.click(1,home_drycargo_checkall);
        return new JMDrycargoPage();
    }

    /**
     * 【测试点】检查是否存在每日直播title
     */
    public Boolean isHaveHomeDailyliveTitle(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            return home_dailylive_title.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_dailylive_title");
            return false;
        }
    }

    /**
     * 【测试点】检查是否存在每日直播查看全部入口
     */
    public Boolean isHaveHomeDailyliveCheckall(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            return home_drycargo_checkall.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_drycargo_checkall");
            return false;
        }
    }

    /**
     * 【测试点】检查是否存在每日直播入口
     */
    public Boolean isHaveHomeDailyliveEnter(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            return home_dailylive_enter.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_dailylive_enter");
            return false;
        }
    }

    /**
     * 【测试点】检查每日直播栏目名称是否为'谈股论金'
     */
    public Boolean isTrueHomeDailyliveName(){
        try{
            PageAction.switchToWebview();   //切换至WebView模式
            String home_dailylive_nameText = home_dailylive_name.getText();
            System.out.println("每日直播栏目名称:" + home_dailylive_nameText);
            if (home_dailylive_nameText.equals("谈股论金")){
                return true;
            }
            else {
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_dailylive_name");
            return false;
        }
    }

    /**
     * 【测试点】检查每日直播信息栏正确展示
     * @return
     */
    public Boolean isTrueHomeDailylivePerson(){
        try{
            PageAction.switchToWebview();   //切换至WebView模式
            String personText = home_dailylive_person.getText();
            System.out.println("每日直播信息:" + personText);
            if(personText.length() > 0){
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException n){
            System.out.println("【异常】找不到元素:home_dailylive_person");
            return false;
        }
    }

    /**
     * 【测试点】检查每日干货是否展示文章列表
     * @return
     */
    public Boolean isHaveHomeDrycargoList(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            return home_drycargo_list.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_drycargo_list");
            return false;
        }
    }

    /**
     * 【测试点】检查每日干货首篇文章主题正确展示
     * @return
     */
    public Boolean isHaveHomeDrycargoArticleTitle() {
        try {
            PageAction.switchToWebview();  //切换至WebView模式
            String title = home_drycargo_articletitle.getText();
            if(title.length() > 0 & title.equals("null")){
                return true;
            }else {
                return false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("【异常】找不到元素:home_drycargo_articletitle");
            return false;
        }
    }

    /**
     * 【测试点】检查每日干货首篇文章日期格式是否正确
     * @return
     */
    public Boolean isHaveHomeDrycargoArticleDate(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            String date = home_drycargo_articledate.getText();
            System.out.println("每日干货首篇文章日期:" + date);
            int month = Integer.parseInt(date.substring(0,2));
            int day = Integer.parseInt(date.substring(3,5));
            if ((month > 0 && month < 13) && (day > 0 && day < 32)){
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException e) {
            System.out.println("【异常】找不到元素:home_drycargo_articledate");
            return false;
        }
    }

    /**
     * 【测试点】检查每日干货随机任意文章是否可以正常跳转
     */
    public void isGoHomeDrycargoArticle(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            Random random = new Random();
            switch (random.nextInt(3)){
                case 0:
                    PageAction.click(10,home_drycargo_enter1);  //点击第一篇文章跳转
                    break;
                case 1:
                    PageAction.click(10,home_drycargo_enter2);  //点击第二篇文章跳转
                    break;
                case 2:
                    PageAction.click(10,home_drycargo_enter3);  //点击第三篇文章跳转
                    break;
            }
            this.goBack();    //返回首页
        }catch (Exception e){
            System.out.println("【异常】跳转失败");
        }
    }

    /**
     * 【测试点】检查明日投资看点是否存在
     * @return
     */
    public Boolean isHaveHomeVideoMr(){
        try{
            PageAction.switchToWebview();  //切换至WebView模式
            return home_video_mr.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_mr");
            return false;
        }
    }

    /**
     * 【测试点】检查投资学院是否存在
     * @return
     */
    public void isHaveHomeVideoTz(){
        System.out.println(home_video_mr);
    }
}