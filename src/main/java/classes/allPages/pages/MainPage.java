package classes.allPages.pages;

import classes.allPages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
    private final By cardOfBook = By.xpath("//div[contains(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]");
    private final By headOfJava2 = By.xpath("//span[contains(text(), 'Head First Java, 2nd Edition')]");
    private final By BSeller = By.xpath("//i[@class=\"a-icon a-icon-addon p13n-best-seller-badge\"]");



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

    public MainPage findAllBooksInPage(List<String>bookInfoList ){

        List<WebElement> booksElementsList = driver.findElements(cardOfBook);

        for(WebElement element : booksElementsList){
            String string = element.getText().replaceAll("\n", " ");
            bookInfoList.add(string);
            System.out.println(string);
            System.out.println("-------------------------------");
        }
        return this;
    }

    public MainPage checkThatBookIsPresent(){
     driver.findElement(headOfJava2).click();
     return this;
    }

    public MainPage findParamInHeadOfJava2(){


        String bookTitle =  driver.findElement(By.id("productTitle")).getText();
        String author = driver.findElement(By.id("bylineInfo")).getText();
        String price = driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-price a-color-price\"]")).getText();
        String isBestseller = driver.findElements(BSeller).isEmpty() ? "No" : driver.findElement(BSeller).getText();

        String bookInfo = "Title: " + bookTitle + ", Author: " + author + ", Price: " + price + ", Bestseller: " + isBestseller;
        System.out.println(bookInfo);
       return this;
    }

}
