package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page基类，提供各页面间重复功能
 * 1.PageFactory页面元素初始化  2.页面截图（非等待）
 */
public class BasePage {
    /**
     * 初始化页面元素
     */
    public BasePage(){
        //System.out.println("-------------初始化页面");
        PageFactory.initElements(Driver.getDriverWX(),this);
    }
}
