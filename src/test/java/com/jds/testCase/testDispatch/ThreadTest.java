package com.jds.testCase.testDispatch;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest implements Runnable{
    @Override
    public void run() {
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add(System.getProperty("user.dir") + "/src/test/java/com/jds/testCase/testNGXML/testng.xml");
        testNG.setTestSuites(suites);
        testNG.run();
        System.out.println("当前线程ID: " + Thread.currentThread().getName());
    }

    public static void  main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        for(int i = 0;i<2;i++){
            System.out.println("启动第" + (i+1) + "个线程.");
            new Thread(threadTest,"haha" + i).start();
        }
    }
}
