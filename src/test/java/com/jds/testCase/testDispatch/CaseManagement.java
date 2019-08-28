package com.jds.testCase.testDispatch;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回测试用例集合
 */
public class CaseManagement {
    /**
     * 从testCase.xml文件中读取测试用例集合
     */
    public Element ReadCaseXML(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(System.getProperty("user.dir") + "/config/testCase.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element project = document.getRootElement();
        return project;
    }

    /**
     * 获取解码直播测试用例
     * @return
     */
    public Map jmCaseList (){
        Element project = this.ReadCaseXML();
        Element wxmini = project.element("wxmini");
        Element jmzb = wxmini.element("jmzb");
        List<Element> Case = jmzb.elements("case");

        Map<Integer,String> map = new HashMap();
        map.put(1,"com.jds.testCase.caseList.WX.test5");
        map.put(2,"com.jds.testCase.caseList.WX.test6");
        /**
        map.put(3,"com.jds.testCase.caseList.WX.test7");
        map.put(4,"com.jds.testCase.caseList.WX.test8");
        map.put(5,"com.jds.testCase.caseList.WX.test9");
        map.put(6,"com.jds.testCase.caseList.WX.test10");
        map.put(7,"com.jds.testCase.caseList.WX.test11");
        map.put(8,"com.jds.testCase.caseList.WX.test12");
        map.put(9,"com.jds.testCase.caseList.WX.test13");
        map.put(10,"com.jds.testCase.caseList.WX.test14");
         */
        return map;
    }

    public static void main(String[] args){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(System.getProperty("user.dir") + "/config/testCase.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element project = document.getRootElement();
        Element wxmini = project.element("wxmini");
        Element jmzb = wxmini.element("jmzb");
        List<Element> Case = jmzb.elements("case");
        System.out.println(Case.get(1).getText());
    }
}
