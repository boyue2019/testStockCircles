package com.jds.testCase.testDispatch;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args){
        TestNG testNG = new TestNG();

        //设置Suite标签
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("解码直播小程序自动化");
        xmlSuite.setParallel("classes");
        xmlSuite.setThreadCount(10);

        //设置Test标签
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("测试并发执行用例");
        xmlTest.setVerbose(2);

        //设置Class标签
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("com.jds.testCase.caseList.WX.test5"));
        classes.add(new XmlClass("com.jds.testCase.caseList.WX.test6"));
        xmlTest.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(xmlSuite);

        //testNG.setXmlSuites(suites);
        //testNG.run();
        System.out.println(xmlTest.getClasses().get(0).getName());
    }
}
