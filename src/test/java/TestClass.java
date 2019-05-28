import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Description;
import org.testng.annotations.*;

public class TestClass{
    private static int counter;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " beforeSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " BeforeClass");
    }

    @BeforeMethod
    public void resetPage(){
        String isRetry = System.getProperty("isRetry");
        System.out.println("isRetry:" + isRetry);
        if (isRetry == "true"){
            System.out.println("重置页面.");
            beforeClass();
        }
        System.setProperty("isRetry","false"); //　重置页面后重置状态
    }

    /**
    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " afterSuite");
    }

     @AfterTest
     public void afterTest() {
     System.out.println(this.getClass().getName() + " afterTest");
     }


    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " afterClass");
    }

    @BeforeMethod
    public void beofreMethod() {
        System.out.println(this.getClass().getName() + " beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(this.getClass().getName() + " afterMethod");
    }
     */

    @Test(groups = {RGroupName.FT,RGroupName.RT})
    public void test1() {
        System.out.println(this.getClass().getName() + " test1");
    }

    @Test(groups = {RGroupName.FT,RGroupName.CT})
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }

    @Test(groups = {RGroupName.FT,RGroupName.RT})
    public void test3() {
        System.out.println(this.getClass().getName() + " test3");
        //Assert.assertEquals("1", "2");
    }

    @Test(groups = {RGroupName.RT})
    public void test4() {
        System.out.println(this.getClass().getName() + " test4");
        //Assert.assertEquals("1", "2");
    }

    @Test(groups = {RGroupName.RT})
    public void test5() {
        System.out.println(this.getClass().getName() + " test5");
    }
}




