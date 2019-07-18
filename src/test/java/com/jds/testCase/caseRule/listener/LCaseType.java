package com.jds.testCase.caseRule.listener;

import com.jds.testBase.util.CommonTools;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.*;

/**
 * 指定测试类型:
 * FunctionalTesting 功能测试 || RegressionTesting 回归测试 || CompatibilityTesting 兼容性测试
 * 从config.properties中读取当前运行的测试用例类型
 */
public class LCaseType implements IMethodInterceptor{
    private static String runType = null;

    public List<IMethodInstance> intercept(List<IMethodInstance> methodInstances, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        //从config.properties中读取用例类型
        CommonTools commonTools = new CommonTools();
        runType = commonTools.getConfigData("RunType");

        //遍历所有Method
        for (IMethodInstance methodInstance : methodInstances) {
            ITestNGMethod method = methodInstance.getMethod();
            Set<String> groups = new HashSet<String>();

            if (method.isTest()) { //获取@Test注解的所有groups
                for (String group : method.getGroups()) {
                    groups.add(group);
                }
            }
            if (groups.contains(runType))  //若groups含配置项中的测试类型,则添加到caseList中
                result.add(methodInstance);
        }
        return result;
    }
}
