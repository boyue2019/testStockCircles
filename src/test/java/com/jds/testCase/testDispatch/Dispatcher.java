package com.jds.testCase.testDispatch;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dispatcher {

    /**
     * 根据设备数量将用例拆分到不同组
     * @param devciesCount
     * @return
     */
    public List CaseSplit(int devciesCount){
        TestCase testCase = new TestCase();
        Map<Integer,String> map = testCase.GetCaseList();
        int caseCount = map.size();  //获取用例总数[10]
        int roundNum = 0;
        int counter = 1;
        List<List> caseGather = new ArrayList<List>();

        for(int i = 1;i < devciesCount + 1;i++){
            List<String> classlist = new ArrayList<String>();

            //若用例数与设备数整除
            if (caseCount%devciesCount==0){
                roundNum = caseCount/devciesCount;
                for (int s = 1;s < roundNum + 1;s++){
                    classlist.add(map.get(counter));
                    counter++;
                }
                caseGather.add(classlist);
            }else {  //若非整除
                if(i==devciesCount){
                    roundNum = caseCount-(caseCount/devciesCount)*(devciesCount-1);
                }else {
                    roundNum = caseCount/devciesCount;
                }
                for (int k = 1;k < roundNum + 1;k++){
                    classlist.add(map.get(counter));
                    counter++;
                }
                caseGather.add(classlist);
            }
        }
        return caseGather;
    }

    /**
     * 动态生成testNG.xml
     * 用例平均分配到多个Test标签下并发执行
     * @param devciesCount
     * @return
     */
    public TestNG TestNGXML(int devciesCount){
        TestNG testNG = new TestNG();
        List<List> caseGather = this.CaseSplit(devciesCount);

        //设置Suite标签
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("解码直播小程序自动化");   //套件Name
        xmlSuite.setParallel("tests");           //并发级别;tests|classes|methods
        xmlSuite.setThreadCount(devciesCount);   //线程数;等于设备数

        //设置Test|Classes标签
        List<XmlTest> xmlTestList = new ArrayList<XmlTest>();
        for(int t = 0;t < devciesCount;t++){
            XmlTest xmlTest = new XmlTest(xmlSuite);
            xmlTest.setName("设备:" + (t+1));
            xmlTest.setVerbose(2);

            List<String> classlist = caseGather.get(t);
            List<XmlClass> classes = new ArrayList<XmlClass>();
            for(int c = 0;c < classlist.size();c++){
                classes.add(new XmlClass(classlist.get(c)));
            }
            xmlTest.setXmlClasses(classes);
            xmlTestList.add(xmlTest);
        }

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(xmlSuite);

        testNG.setXmlSuites(suites);
        return testNG;
    }

    public static void main(String[] args){
        int devciesCount = 3; //设备数

        Dispatcher dispatcher = new Dispatcher();
        TestNG testNG = dispatcher.TestNGXML(devciesCount);
        testNG.run();
    }
}