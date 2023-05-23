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
    private final By finderButton = By.id("nav-search-submit-button");
    private final By cardOfBook = By.cssSelector("div[data-component-type='s-search-result']");
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


    public MainPage findParam(List<Book> bookInfoList){

        List<WebElement> bookElements = driver.findElements(cardOfBook);


        for (WebElement bookElement : bookElements) {
            WebElement title = bookElement.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
            WebElement author = bookElement.findElement(By.xpath(".//div[@class='a-row']/span[contains(text(), 'by')]/following-sibling::*[1]"));
            WebElement price = bookElement.findElement(By.xpath(".//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']/parent::*"));
            // WebElement isBestseller = bookElement.findElement(By.xpath(".//span[contains(text(), 'Best Seller')]"));

            Book book = new Book();

            if(title != null & author != null & price !=null){
                book.setTitle(title.getText());
                book.setAuthor(author.getText());
                book.setPrice(price.getText().replaceAll("(?<=\\d)\\n|\\n(?=\\d)", ".").replaceAll("\\n", " "));
              //  book.setIsBestseller(isBestseller.getText());



            }else {
                book.setTitle("null");
                book.setAuthor("null");
                book.setPrice("null");
              //  book.setIsBestseller("null");
            }


            bookInfoList.add(book);

        }

        for (Book bookInfo : bookInfoList) {
            System.out.print("Title: " + bookInfo.getTitle()+" | ");
            System.out.print("author: " + bookInfo.getAuthor()+" | ");
            System.out.print("price: " + bookInfo.getPrice()+" | ");
            System.out.print("setIsBestseller: " + bookInfo.getIsBestseller()+" | ");
            System.out.println();
        }

        return this;
    }


    public boolean compareObjects(Book book, List<Book> bookList) {
        String title = driver.findElement(By.id("productTitle")).getText();
        String author = driver.findElement(By.xpath("//a[contains(text(), 'Kathy Sierra')]")).getText();
        String price = driver.findElement(By.xpath("//a[@id=\"a-autoid-3-announce\"]/span[@class=\"a-color-secondary\"]")).getText().replaceAll(" (.*)", "");
        //String bestSeller = driver.findElement(By.xpath("//*[@class=\"a-icon a-icon-addon p13n-best-seller-badge\"]")).getText();

        book = new Book(title, author, price,null);

        for (Book book1 : bookList) {
            if (    book1.getTitle().contains(book.getTitle())
                    && book1.getAuthor().contains(book.getAuthor())
                    && book1.getPrice().contains(book.getPrice())

                )
            {
                System.out.println(book1.getTitle());
                System.out.println(book1.getAuthor());
                System.out.println(book1.getPrice());
                System.out.println(book1.getIsBestseller());

                System.out.println("Об'єкт знайдено у списку.");
                return true;
            } else {
                System.out.println(book.getTitle());
                System.out.println(book.getAuthor());
                System.out.println(book.getPrice());
                System.out.println(book.getIsBestseller());
                System.out.println("Об'єкт відсутній у списку.");
                return false;
            }
        }

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        System.out.println(book.getIsBestseller());

        return false;
    }






}
