package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.PageAction;
import com.jds.testCase.caseList.WX.BaseCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page基类，提供各页面间重复功能
 * 1.PageFactory页面元素初始化  2.页面截图（非等待）
 */
public class BasePage {
    //暂停专用
    @FindBy(xpath = "//*[@text='找到算我输']")
    @CacheLookup
    static WebElement stop2;

    //返回上一级 【NATIVE_APP】
    //备注:非一级页面返回按钮都相同
    @FindBy(id = "com.tencent.mm:id/p8")
    @CacheLookup
    static WebElement back;  //返回上一级

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
     * 返回首页
     */
    public static void goBack(){
        PageAction.switchToNative();
        for(int i = 0;i < 10;i++){
            if (back.isDisplayed()){
                PageAction.click(5,back);
            }else {
                System.out.println("已返回到首页或找不到返回元素.");
                break;
            }
        }

    }
}
