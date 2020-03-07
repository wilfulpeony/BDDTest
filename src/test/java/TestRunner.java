import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static org.DriverFactory.getDriver;

@RunWith(Cucumber.class)
public class TestRunner {

    @AfterClass
    public static void finishTestRun(){
        getDriver().close();
        getDriver().quit();
    }
}
