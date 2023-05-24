package tests.base;

import classes.allPages.base.BasePage;
import classes.allPages.pages.HeadFirst;
import classes.allPages.pages.JavaPage;
import classes.allPages.pages.MainPage;
import classes.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static classes.common.Config.CLEAR_STORAGE;
import static classes.common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver ;
    protected BasePage basePage;
    protected MainPage mainPage ;
    protected JavaPage javaPage ;
    protected HeadFirst headFirst ;


    @BeforeTest
    public void setDriver(){
        driver = CommonActions.createDriver();
        basePage = new BasePage(driver);

    }


    @AfterTest
    public void clearCookLocalStorage(){
        if (CLEAR_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite
    public void close(){
        if (HOLD_BROWSER_OPEN){
            driver.close();
            driver.quit();
        }
    }

}
