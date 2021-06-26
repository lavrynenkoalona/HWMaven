package UnitTests;

import UnitTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringWorkerTest extends BaseTest {
    StringWorker stringWorker = new StringWorker();

    //@Test
    public void setStringWorker1Test() {
        String expectedValue = "QWErty123";
        Assert.assertEquals(stringWorker.concatenate("QWE", "rt", "y123"), expectedValue, "concatenate works wrong, expected value - " + expectedValue);

    }

    //@Test
    public void setStringWorker2Test() {
        String expectedValue = "1234567890qwe";
        Assert.assertEquals(stringWorker.concatenate("123", "456789", "0qwe"), expectedValue, "concatenate works wrong, expected value - " + expectedValue);

    }

//    @Test(dataProvider = "geData")
//    public void instanceDtProvider(int p1, String p2) {
//        System.out.println("Instance DataProvider Example: Data(" + p1 + " , " + p2 + ")");
//    }

    //@DataProvider
    public Object[][] getData() {

        return new Object[][]{
                {5, "five"},
                {6, "six"},
                {7,"QWE"}
        };

    }

}
