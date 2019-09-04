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

    //每日干货 - 第二篇文章的入口
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[2]/wx-view/wx-form/span/wx-button")
    @CacheLookup
    private WebElement home_drycargo_enter2;

    //每日干货 - 第三篇文章的入口
    @FindBy(xpath = "//wx-view[@id='home_drycargo_list']/wx-complisten[3]/wx-view/wx-form/span/wx-button")
    @CacheLookup
    private WebElement home_drycargo_enter3;

    //明日投资看点 - 区域top
    @FindBy(id = "home_video_item0")
    @CacheLookup
    private WebElement home_video_mr;

    //明日投资看点 - 标题
    @FindBy(xpath = "//wx-view[@id='home_video_item0']//wx-view[@id='home_video_title']")
    @CacheLookup
    private WebElement home_video_mr_title;

    //明日投资看点 - 查看全部
    @FindBy(xpath = "//wx-view[@id='home_video_item0']//wx-button[@id='home_video_checkall']")
    @CacheLookup
    private WebElement home_video_mr_checkall;

    //明日投资看点 - 视频1入口
    @FindBy(xpath = "//wx-view[@id='home_video0']//wx-scroll-view[@id='home_video_list0']")
    @CacheLookup
    private WebElement home_video_mr_venter1;

    //明日投资看点 - 视频1标题
    @FindBy(xpath = "//wx-view[@id='home_video0']//wx-scroll-view[@id='home_video_list0']//wx-view[@id='home_video_title2']")
    @CacheLookup
    private WebElement home_video_mr_vtitle1;

    //明日投资看点 - 视频2入口
    @FindBy(xpath = "//wx-view[@id='home_video0']//wx-scroll-view[@id='home_video_list1']")
    @CacheLookup
    private WebElement home_video_mr_venter2;

    //明日投资看点 - 视频2标题
    @FindBy(xpath = "//wx-view[@id='home_video0']//wx-scroll-view[@id='home_video_list1']//wx-view[@id='home_video_title2']")
    @CacheLookup
    private WebElement home_video_mr_vtitle2;

    //投资学院 - 区域top
    @FindBy(id = "home_video_item1")
    @CacheLookup
    private WebElement home_video_tz;

    //投资学院 - 标题
    @FindBy(xpath = "//wx-view[@id='home_video_item1']//wx-view[@id='home_video_title']")
    @CacheLookup
    private WebElement home_video_tz_title;

    //投资学院 - 查看全部
    @FindBy(xpath = "//wx-view[@id='home_video_item1']//wx-button[@id='home_video_checkall']")
    @CacheLookup
    private WebElement home_video_tz_checkall;

    //投资学院 - 视频1入口
    @FindBy(xpath = "//wx-view[@id='home_video1']//wx-scroll-view[@id='home_video_list0']")
    @CacheLookup
    private WebElement home_video_tz_venter1;

    //投资学院 - 视频1标题
    @FindBy(xpath = "//wx-view[@id='home_video1']//wx-scroll-view[@id='home_video_list0']//wx-view[@id='home_video_title2']")
    @CacheLookup
    private WebElement home_video_tz_vtitle1;

    //投资学院 - 视频2入口
    @FindBy(xpath = "//wx-view[@id='home_video1']//wx-scroll-view[@id='home_video_list1']")
    @CacheLookup
    private WebElement home_video_tz_venter2;

    //投资学院 - 视频2标题
    @FindBy(xpath = "//wx-view[@id='home_video1']//wx-scroll-view[@id='home_video_list1']//wx-view[@id='home_video_title2']")
    @CacheLookup
    private WebElement home_video_tz_vtitle2;

    /**
     * 【事件】切换至包含当前页面元素WindowHandel
     */
    public void jumpHomeWindowHandel(){
        this.waitBottomElement();   //等待元素出现
        PageAction.switchToWebview(); //切换至WebView模式
        PageAction.jumpToWindowHandel(home_drycargo_checkall);  //切换至存在'每日干后-查看全部'的WindowHandel
    }

    /**
     * 【事件】跳转至每日干货查看全部
     * @return
     */
    public JMDrycargoPage gotoJMDrycargoCheckAll(){
        PageAction.click(1,home_drycargo_checkall);
        return new JMDrycargoPage();
    }

    /**
     * 【测试点】检查每日直播title是否成功加载
     */
    public Boolean isHaveHomeDailyliveTitle(){
        try{
            return home_dailylive_title.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_dailylive_title");
            return false;
        }
    }

    /**
     * 【测试点】检查每日直播查看全部入口是否成功加载
     */
    public Boolean isHaveHomeDailyliveCheckall(){
        try{
            return home_drycargo_checkall.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_drycargo_checkall");
            return false;
        }
    }

    /**
     * 【测试点】检查每日直播入口是否成功加载
     */
    public Boolean isHaveHomeDailyliveEnter(){
        try{
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
     * 【测试点】检查明日投资看点是否成功加载
     * @return
     */
    public Boolean isHaveHomeVideoMr(){
        try{
            return home_video_mr.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_mr");
            return false;
        }
    }

    /**
     * 【测试点】检查明日投资看点标题是否正确展示
     * @return
     */
    public Boolean isTrueHomeVideoMrTitle(){
        try{
            String title = home_video_mr_title.getText();
            if (title.equals("明日投资看点")){
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_mr_title");
            return false;
        }
    }

    /**
     * 【测试点】检查明日投资看点查看全部入口是否成功加载
     * @return
     */
    public Boolean isHaveHomeVideoMrCheckall(){
        try{
            return home_video_mr_checkall.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_mr_checkall");
            return false;
        }
    }

    /**
     * 【测试点】检查明日投资看点任意随机视频标题是否正确展示
     */
    public Boolean isTrueHomeVideoMrVtitle(){
        try {
            Random random = new Random();
            String title = "";
            int num = 0;
            switch (random.nextInt(2)){
                case 0:
                    title = home_video_mr_vtitle1.getText();
                    num = 1;
                    break;
                case 1:
                    title = home_video_mr_vtitle2.getText();
                    num = 2;
                    break;
            }
            if (title.length() > 0 && !title.equals("null")){
                System.out.println("投资学院第" + num + "篇文章的标题:" + title);
                return true;
            }else {
                System.out.println("投资学院第" + num + "篇文章的标题:" + title);
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_mr_vtitle");
            return false;
        }
    }

    /**
     * 【测试点】检查投资学院看点是否成功加载
     * @return
     */
    public Boolean isHaveHomeVideoTz(){
        try{
            return home_video_tz.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_tz");
            return false;
        }
    }

    /**
     * 【测试点】检查投资学院标题是否正确展示
     * @return
     */
    public Boolean isTrueHomeVideoTzTitle(){
        try{
            String title = home_video_tz_title.getText();
            if (title.equals("投资学院")){
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_tz_title");
            return false;
        }
    }

    /**
     * 【测试点】检查投资学院查看全部入口是否成功加载
     * @return
     */
    public Boolean isHaveHomeVideoTzCheckall(){
        try{
            return home_video_tz_checkall.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_tz_checkall");
            return false;
        }
    }

    /**
     * 【测试点】检查投资学院任意随机视频标题是否正确展示
     */
    public Boolean isTrueHomeVideoTzVtitle(){
        try {
            Random random = new Random();
            String title = "";
            int num = 0;
            switch (random.nextInt(2)){
                case 0:
                    title = home_video_tz_vtitle1.getText();
                    num = 1;
                    break;
                case 1:
                    title = home_video_tz_vtitle2.getText();
                    num = 2;
                    break;
            }
            if (title.length() > 0 && !title.equals("null")){
                System.out.println("投资学院第" + num + "篇文章的标题:" + title);
                return true;
            }else {
                System.out.println("投资学院第" + num + "篇文章的标题:" + title);
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:home_video_tz_vtitle");
            return false;
        }
    }

    public static void main(String[] args){
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }
}