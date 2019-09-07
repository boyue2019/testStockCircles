package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

/**
 * 微课主页
 */
public class JMWeiKePage extends BasePage{
    //第一个微课
    @FindBy(id = "microclass_list0")
    @CacheLookup
    private WebElement microclass_list0;

    //第一个微课title
    @FindBy(xpath = "//wx-view[@id='microclass_list0']//wx-view[@id='microclass_title']")
    @CacheLookup
    private WebElement microclass_title0;

    //第一个微课入口
    @FindBy(xpath = "//wx-view[@id='microclass_list0']//wx-button")
    @CacheLookup
    private WebElement microclass_enter0;

    //第一个微课简介
    @FindBy(xpath = "//wx-view[@id='microclass_list0']//wx-view[@id='microclass_profile']")
    @CacheLookup
    private WebElement microclass_profile0;

    //第二个微课
    @FindBy(id = "microclass_list1")
    @CacheLookup
    private WebElement microclass_list1;

    //第二个微课title
    @FindBy(xpath = "//wx-view[@id='microclass_list1']//wx-view[@id='microclass_title']")
    @CacheLookup
    private WebElement microclass_title1;

    //第二个微课入口
    @FindBy(xpath = "//wx-view[@id='microclass_list1']//wx-button")
    @CacheLookup
    private WebElement microclass_enter1;

    //第二个微课简介
    @FindBy(xpath = "//wx-view[@id='microclass_list1']//wx-view[@id='microclass_profile']")
    @CacheLookup
    private WebElement microclass_profile1;

    //第三个微课
    @FindBy(id = "microclass_list2")
    @CacheLookup
    private WebElement microclass_list2;

    //第三个微课title
    @FindBy(xpath = "//wx-view[@id='microclass_list2']//wx-view[@id='microclass_title']")
    @CacheLookup
    private WebElement microclass_title2;

    //第三个微课入口
    @FindBy(xpath = "//wx-view[@id='microclass_list2']//wx-button")
    @CacheLookup
    private WebElement microclass_enter2;

    //第三个微课简介
    @FindBy(xpath = "//wx-view[@id='microclass_list2']//wx-view[@id='microclass_profile']")
    @CacheLookup
    private WebElement microclass_profile2;

    //第四个微课
    @FindBy(id = "microclass_list3")
    @CacheLookup
    private WebElement microclass_list3;

    //第四个微课title
    @FindBy(xpath = "//wx-view[@id='microclass_list3']//wx-view[@id='microclass_title']")
    @CacheLookup
    private WebElement microclass_title3;

    //第四个微课入口
    @FindBy(xpath = "//wx-view[@id='microclass_list3']//wx-button")
    @CacheLookup
    private WebElement microclass_enter3;

    //第四个微课简介
    @FindBy(xpath = "//wx-view[@id='microclass_list3']//wx-view[@id='microclass_profile']")
    @CacheLookup
    private WebElement microclass_profile3;

    //第五个微课
    @FindBy(id = "microclass_list4")
    @CacheLookup
    private WebElement microclass_list4;

    //第五个微课title
    @FindBy(xpath = "//wx-view[@id='microclass_list4']//wx-view[@id='microclass_title']")
    @CacheLookup
    private WebElement microclass_title4;

    //第五个微课入口
    @FindBy(xpath = "//wx-view[@id='microclass_list4']//wx-button")
    @CacheLookup
    private WebElement microclass_enter4;

    //第五个微课简介
    @FindBy(xpath = "//wx-view[@id='microclass_list4']//wx-view[@id='microclass_profile']")
    @CacheLookup
    private WebElement microclass_profile4;

    /**
     * 切换至包含当前页面元素的handel
     */
    public void jumpWeikeWindowHandel(){
        PageAction.switchToWebview(); //切换至WebView模式
        PageAction.jumpToWindowHandel(microclass_list0);  //切换至包含当前页面元素的WindowHandel
    }

    /**
     * 【测试点】检查微课列表至少成功加载4个微课
     * @return
     */
    public Boolean isHaveMicroclass(){
        try{
            if(microclass_list0.isDisplayed() &&
                    microclass_list1.isDisplayed() &&
                    microclass_list2.isDisplayed() &&
                    microclass_list3.isDisplayed()){
                return true;
            }else {
                System.out.println("【异常】微课少于4个");
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:microclass_list");
            return false;
        }
    }

    /**
     * 【测试点】检查微课列表随意任意微课的主题是否展示正确
     * @return
     */
    public Boolean isTrueMicroclassTitle(){
        try{
            Random random = new Random();
            String title = "";
            int num = random.nextInt(5);
            switch (num){
                case 0:
                    title = microclass_title0.getText();
                    break;
                case 1:
                    title = microclass_title1.getText();
                    break;
                case 2:
                    title = microclass_title2.getText();
                    break;
                case 3:
                    title = microclass_title3.getText();
                    break;
                case 4:
                    title = microclass_title4.getText();
                    break;
            }
            if (title.length() > 0 && !title.equals("null")){
                System.out.println("第" + (num+1) + "个微课的主题:" + title);
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:microclass_title");
            return false;
        }
    }

    /**
     * 【测试点】检查微课列表随机任意课程是否可以正常跳转
     */
    public void isGoMicroclassDetil(){
        try{
            Random random = new Random();
            switch (random.nextInt(5)){
                case 0:
                    PageAction.click(10,microclass_enter0);
                    break;
                case 1:
                    PageAction.click(10,microclass_enter1);
                    break;
                case 2:
                    PageAction.click(10,microclass_enter2);
                    break;
                case 3:
                    PageAction.click(10,microclass_enter3);
                    break;
                case 4:
                    PageAction.click(10,microclass_enter4);
                    break;
            }
            this.goBack();  //返回首页
        }catch (Exception e){
            System.out.println("【异常】跳转失败:home_drycargo_enter");
        }
    }

    /**
     * 【测试点】检查微课列表随意任意微课的简介是否展示正确
     * @return
     */
    public Boolean isTrueMicroclassProfile(){
        try{
            Random random = new Random();
            String title = "";
            int num = random.nextInt(5);
            switch (num){
                case 0:
                    title = microclass_profile0.getText();
                    break;
                case 1:
                    title = microclass_profile1.getText();
                    break;
                case 2:
                    title = microclass_profile2.getText();
                    break;
                case 3:
                    title = microclass_profile3.getText();
                    break;
                case 4:
                    title = microclass_profile4.getText();
                    break;
            }
            if (title.length() > 0 && !title.equals("null")){
                System.out.println("第" + (num+1) + "个微课的简介:" + title);
                return true;
            }else {
                return false;
            }
        }catch (NoSuchElementException e){
            System.out.println("【异常】找不到元素:microclass_profile");
            return false;
        }
    }

}
