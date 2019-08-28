package com.jds.testCase.caseList.WX;

import org.testng.annotations.*;

public class test5 {
    @Test
    @Parameters({"port","bp","chromedrniverport","system","serial","height","width","manufacturer","model","version"})
    public void test1(String port,
                      String bp,
                      String chromedrniverport,
                      String system,
                      String serial,
                      String height,
                      String width,
                      String manufacturer,
                      String model,
                      String version) {
        System.out.println(port);
        System.out.println(bp);
        System.out.println(chromedrniverport);
        System.out.println(system);
        System.out.println(serial);
        System.out.println(height);
        System.out.println(width);
        System.out.println(manufacturer);
        System.out.println(model);
        System.out.println(version);
    }

    @Test
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }
}
