package com.jds.testCase.caseList.WX;

import org.testng.annotations.*;

public class test6 {
    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " afterClass");
    }

    @BeforeMethod
    public void beofreMethod() {
        System.out.println(this.getClass().getName() + " beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(this.getClass().getName() + " afterMethod");
    }

    @Test
    public void test1() {
        System.out.println(this.getClass().getName() + " test1");
    }

    @Test
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }
}
