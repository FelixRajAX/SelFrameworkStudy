package DriverFactory;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;


public class DrInstantiation
{
    WebDriver driver = null;
    WebDriverListener MyListener = new SelEventCapture();

    public WebDriver edgelaunch(String url){
        System.setProperty("webdriver.edge.driver",
                "src/test/Resources/msedgedriver.exe");
        driver = new EdgeDriver();
        WebDriver EdgeMaskedEvenCaptureDrObj = MaskWebDrObj(MyListener, driver);
        openurl(EdgeMaskedEvenCaptureDrObj,url);
        return EdgeMaskedEvenCaptureDrObj;
    }

    public WebDriver chromelaunch(String url){
        System.setProperty("webdriver.chrome.driver",
                "src/test/Resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriver ChromeMaskedEvenCaptureDrObj = MaskWebDrObj(MyListener, driver);
        openurl(ChromeMaskedEvenCaptureDrObj,url);
        return ChromeMaskedEvenCaptureDrObj;
    }

    public WebDriver firefoxlaunch(String url) {
        // Set the Path to Edge Driver.exe
        System.setProperty("webdriver.firefox.driver",
                "src/test/Resources/geckodriver.exe");
        driver = new FirefoxDriver();
        WebDriver FirefxMaskedEvenCaptureDrObj = MaskWebDrObj(MyListener, driver);
        openurl(FirefxMaskedEvenCaptureDrObj,url);
        return FirefxMaskedEvenCaptureDrObj;
    }


    public void openurl(WebDriver driver, String url){
        driver.get(url);
    }
    public WebDriver MaskWebDrObj(WebDriverListener wl, WebDriver dr){
        return new EventFiringDecorator<>(wl).decorate(dr);
    }

    public void Takescreenshot(WebDriver dr){
        try{
            double rd = Math.random();
            TakesScreenshot takscr = (TakesScreenshot) dr;
            File scrfile = takscr.getScreenshotAs(OutputType.FILE);
            String pathtosavefile = "target\\TakScrnsht" + "_" + rd + ".png";
            System.out.println(pathtosavefile);
            FileHandler.copy(scrfile, new File(pathtosavefile));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
