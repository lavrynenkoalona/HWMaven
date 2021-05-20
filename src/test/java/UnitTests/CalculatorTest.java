package UnitTests;

import UnitTests.BaseTest;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CalculatorTest extends BaseTest {

    Calculator calculator = new Calculator();


    @BeforeMethod
    public void startUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @Test (timeOut = 400)
    public void test1Sum() {
        //int expectedValue =5;
        assertEquals(calculator.sum(2,3), 5);
    }

    @Test (priority = 1)
    public void test2Sum() {
        //int expectedValue =5;
        assertEquals(calculator.sum(2,0), 2);
    }

    @Test (priority = 2)
    public void test3Sum() {
        //int expectedValue =5;
        assertEquals(calculator.sum(2,-5), -3);
    }

    @Test (dependsOnMethods = {"test3Sum"} )
    public void test1Multiply() {
        assertEquals(calculator.multiply(3,4),12.0);}

    @Test (dependsOnMethods = {"test1Multiply"} )
    public void test2Multiply() {
        assertEquals(calculator.multiply(10,0),0.0);}

    @Test
    public void test3Multiply() {
        assertEquals(calculator.multiply(3,-4),-12.0);}

//    @Ignore
//    @Test (expectedExceptions = {NullPointerException.class})
//    public void test1Divide() {
//        assertEquals(calculator.multiply(12,0),0.0);}

//    @Parameters({"param1"})
//    @Test
//    public void ParameterTestOne(String p1) {
//        System.out.println("Parameter is:" + p1);}


}
