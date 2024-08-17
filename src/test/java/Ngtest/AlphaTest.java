package Ngtest;
import DriverFactory.DrInstantiation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class AlphaTest {

    //Declaring Webdriver object
    WebDriver driver = null;
    DrInstantiation di = new DrInstantiation();

    @Parameters({"Browser", "url"})
    @BeforeMethod
    public void Multi_BrowserLaunch(String Browser, String url) throws InterruptedException {
        if (Browser.equalsIgnoreCase("edge")){
            driver = di.edgelaunch(url);
        } else if (Browser.equalsIgnoreCase("chrome")) {
            driver = di.chromelaunch(url);
        } else if (Browser.equalsIgnoreCase("firefox")) {
            driver = di.firefoxlaunch(url);
        }
    }


    @Test
    public void NavigateToEStore() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Assert.assertNotNull(driver.getTitle());
        Reporter.log("Test completed in as successfully");
    }

    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
