package classes.allPages.pages;

import classes.allPages.base.BasePage;
import classes.entity.Book;
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
    private final By cardOfBook = By.cssSelector("div[data-component-type='s-search-result']");
    private final By finderButton = By.id("nav-search-submit-button");
    private final By headOfJava = By.xpath("//span[contains(text(), 'Head First Java: A Brain-Friendly Guide')]");
    private final By BSeller = By.xpath("//i[@class=\"a-icon a-icon-addon p13n-best-seller-badge\"]");
    private final By bookTitleInBook = By.id("productTitle");
    private final By bookAuthorInBook = By.id("bylineInfo");
    private final By priceInBook = By.xpath("//span[@class=\"a-size-base a-color-price a-color-price\"]");




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

    public MainPage checkThatBookIsPresentAndClick(){
     driver.findElement(headOfJava).click();
     return this;
    }

    public MainPage findParamInHeadOfJava2(){


        String bookTitle =  driver.findElement(bookTitleInBook).getText();
        String author = driver.findElement(bookAuthorInBook).getText();
        String price = driver.findElement(priceInBook).getText();
        String isBestseller = driver.findElements(BSeller).isEmpty() ? "No" : driver.findElement(BSeller).getText();

        String bookInfo = "Title: " + bookTitle + ", Author: " + author + ", Price: " + price + ", Bestseller: " + isBestseller;
        System.out.println(bookInfo);
       return this;
    }










}
