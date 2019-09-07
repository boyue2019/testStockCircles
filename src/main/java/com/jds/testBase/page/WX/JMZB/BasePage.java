package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import com.jds.testCase.caseList.WX.BaseCase;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page基类，提供各页面间重复功能
 * 1.PageFactory页面元素初始化  2.页面截图（非等待）
 */
public class BasePage{
    //暂停专用
    @FindBy(xpath = "//*[@text='找到算我输']")
    @CacheLookup
    static WebElement stop2;

    //返回上一级 【NATIVE_APP】
    //备注:非一级页面返回按钮都相同
    @FindBy(id = "com.tencent.mm:id/p7")
    @CacheLookup
    static WebElement back;  //返回上一级

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[1]")
    @CacheLookup
    static WebElement home;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[2]")
    @CacheLookup
    static WebElement WeiKe;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[3]")
    @CacheLookup
    static WebElement mine;  //底导"首页"

    /**
     * 初始化页面元素
     */
    public BasePage(){
        PageFactory.initElements(BaseCase.ThreadDriver.get().getDriverWX(),this);
    }

    /**
     * 等待页面加载,自定义等待时长
     * @param waitingTime
     */
    public void waitLoading(int waitingTime){
        PageAction.waitElement(waitingTime,stop2);
    }

    /**
     * 返回上一页
     */
    public static void goBack(){
        PageAction.switchToNative();   //切换至Native模式
        PageAction.click(5,back);
        PageAction.switchToWebview();  //切换回WebView模式
    }

    /**
     * 返回首页
     */
    public static void goBackHome(){
        PageAction.switchToNative();   //切换至Native模式
        try{
            for(int i = 0;i < 10;i++){
                if (back.isDisplayed()){
                    PageAction.click(5,back);
                }else {
                    System.out.println("已返回到首页或找不到返回元素.");
                    break;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("已返回到首页或找不到返回元素.");
        }
    }

    @Step("【底部导航】点击进入'首页'")
    public static JMHomePage goToHomePage(){
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
    public static JMWeiKePage goToWeiKePage(){
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
    public static JMMinePage goToMinePage(){
        PageAction.switchToNative();
        JMBottomNavigationPage bottomNavigationPage = new JMBottomNavigationPage();
        PageAction.click(15,JMBottomNavigationPage.mine);
        return new JMMinePage();
    }

}
