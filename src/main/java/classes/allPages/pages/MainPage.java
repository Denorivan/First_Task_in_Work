package classes.allPages.pages;

import classes.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static classes.constants.Constant.VariableForTextBox.enterJavaToTextBox;

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

    public MainPage fillAreaWithText(){
        driver.findElement(textContainer).sendKeys(enterJavaToTextBox);
        return this;
    }

    public MainPage clickButtonToFind(){
        driver.findElement(finderButton).click();
        return this;
    }

}
