package com.jds.testCase.caseList.WX;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class test4 {
    protected test14 t1;

    public void setT1(test14 t1) {
        this.t1 = t1;
    }

    public test14 getT1() {
        return t1;
    }

    @BeforeTest
    @Parameters({"port","bp","chromedrniverport","system","serial","height","width","manufacturer","model","version"})
    public void beforetest(String port,
                           String bp,
                           String chromedrniverport,
                           String system,
                           String serial,
                           String height,
                           String width,
                           String manufacturer,
                           String model,
                           String version){
        test14 t2 = new test14();
        t2.setModel(model);
        this.setT1(t2);
    }
}
