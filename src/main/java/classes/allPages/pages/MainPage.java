package classes.allPages.pages;

import classes.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By allChoose = By.xpath("//div[@class='nav-search-scope nav-sprite']");
    private final By choosingBooks = By.xpath("//option[@value='search-alias=stripbooks-intl-ship']");
    private final By textContainer = By.id("twotabsearchtextbox");
    private final By finderButton = By.id("nav-search-submit-button");




    public MainPage clickToChoose(){
        driver.findElement(allChoose).click();
        return this;
    }

    public MainPage chooseBooks(){
        driver.findElement(choosingBooks).click();
        return this;
    }

    public MainPage fillAreaWithText(String str){
        driver.findElement(textContainer).sendKeys(str);
        return this;
    }

    public MainPage clickButtonToFind(){
        driver.findElement(finderButton).click();
        return this;
    }

}
