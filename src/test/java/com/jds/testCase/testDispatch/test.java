package com.jds.testCase.testDispatch;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add(System.getProperty("user.dir") + "/src/test/java/com/jds/testCase/testNGXML/testng.xml");
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
