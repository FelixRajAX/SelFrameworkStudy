package DriverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class DrInstantiation
{
    WebDriver driver = null;
    WebDriverListener MyListener = new SelEventCapture();

    public WebDriver edgelaunch(String url){
        System.setProperty("webdriver.edge.driver",
                "src/test/Resources/msedgedriver.exe");
        driver = new EdgeDriver();
        WebDriver MaskedEvenCaptureDrObj = MaskWebDrObj(MyListener, driver);
        openurl(MaskedEvenCaptureDrObj,url);
        return MaskedEvenCaptureDrObj;
    }

    public WebDriver chromelaunch(String url){
        System.setProperty("webdriver.chrome.driver",
                "src/test/Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    public WebDriver firefoxlaunch(String url) throws InterruptedException {
        // Set the Path to Edge Driver.exe
        System.setProperty("webdriver.firefox.driver",
                "src/test/Resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    public WebDriver chromelaunch(WebDriver driver) throws InterruptedException {
        // Set the Path to Edge Driver.exe
        System.setProperty("webdriver.chrome.driver",
                "\\NativeDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public void openurl(WebDriver driver, String url){
        driver.get(url);
    }
    public WebDriver MaskWebDrObj(WebDriverListener wl, WebDriver dr){
        return new EventFiringDecorator<>(wl).decorate(dr);
    }
}
