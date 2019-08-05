package com.jds.testBase.page.WX.JMZB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class JMDrycargoPage extends BasePage {
    //启动页 【WebView】
    @FindBy(xpath = "//span[text")
    @CacheLookup
    private WebElement startPage;
}
