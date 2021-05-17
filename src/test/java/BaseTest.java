import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeClass
    public void beforeClassActions() {
        System.out.println("Before Classes");
    }
    @AfterClass
    public void afterClassActions() {
        System.out.println("After Classes");
    }

    @BeforeSuite
    public void beforeSuiteActions() {
        System.out.println("Before Suite");
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuiteActions() {
        System.out.println("After Suite");
    }



}
