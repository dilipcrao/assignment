package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public abstract class AbstractPage {

    protected static final Logger log = LoggerFactory.getLogger(AbstractPage.class);

    protected static final String dvlaUrl = "https://www.gov.uk/get-vehicle-information-from-dvla";

    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    protected static void setDriver(){
        System.setProperty("webdriver.chrome.drive","/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    protected static void quitDriver(){
        log.info("Quitting WebDriver");
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public <T extends AbstractPage> T createPage(Class<T> pageClass) {
        return PageFactory.initElements(getDriver(), pageClass);
    }

}
