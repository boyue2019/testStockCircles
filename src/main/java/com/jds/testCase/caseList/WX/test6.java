package com.jds.testCase.caseList.WX;

import org.testng.annotations.*;

public class test6 extends test4{
    @Test
    public void test1() {
        System.out.println(this.getClass().getName() + ":" + super.t1.getModel());
    }

    @Test
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }
}
