package classes.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static classes.common.Config.PLATFORM_AND_BROWSER_CHROME;
import static classes.constants.Constant.TimeOutVariable.IMPLICIT_WAIT;


public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER_CHROME){
            case "win_chrome":{
                System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            } default:{
                Assert.fail("Incorrect platform for browser name: " + PLATFORM_AND_BROWSER_CHROME);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }


}
