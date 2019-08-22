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
        CaseManagement testCase = new CaseManagement();
        Map<Integer,String> map = testCase.GetCaseList();
        int caseCount = map.size();  //获取用例总数[10]
        int averageNum = caseCount/devciesCount;  //平均分配数
        int roundNum[] = new int[devciesCount];
        int counter = 1;
        List<List> caseGather = new ArrayList<List>();

        //计算每个设备分配用例数
        if(caseCount%devciesCount==0){
            for (int i = 0;i < devciesCount;i++){
                roundNum[i] = averageNum;
            }
        }else {
            int sum = 0;
            for (int t = 0;t < devciesCount;t++){
                roundNum[t] = averageNum;
            }
            for(int r = 0;r < roundNum.length;r++){
                sum = roundNum[r] + sum;
            }
            for(int x = 0;x < (caseCount-sum);x++){
                roundNum[x] = roundNum[x] + 1;
            }
        }

        for(int i = 0;i < devciesCount;i++){
            List<String> classlist = new ArrayList<String>();

            for(int p = 1;p < roundNum[i]+1;p++){
                classlist.add(map.get(counter));
                counter++;
            }
            caseGather.add(classlist);
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
        int devciesCount = 6; //设备数

        Dispatcher dispatcher = new Dispatcher();
        TestNG testNG = dispatcher.TestNGXML(devciesCount);
        testNG.run();
    }
}