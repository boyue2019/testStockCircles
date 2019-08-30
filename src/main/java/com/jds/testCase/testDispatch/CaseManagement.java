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
 * 测试用例管理类
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
        int count = Case.size();  //获取用例数
        Map<Integer,String> map = new HashMap();

        for(int i = 0;i < count;i++){
            map.put(i+1,Case.get(i).getText());
        }
        return map;
    }
}
