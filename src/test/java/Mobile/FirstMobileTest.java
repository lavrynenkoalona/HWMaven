package Mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMobileTest {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception
    {
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
//        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//
//        intList.stream()
//                .map(FirstMobileTest::processInt)
//                .forEach(System.out::println);
//
    }
//
//    public static String processInt(int i)
//    {
//        return i + " value";
//    }



}
