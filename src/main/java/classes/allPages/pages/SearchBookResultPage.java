package classes.allPages.pages;

import classes.allPages.base.BasePage;
import classes.entity.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBookResultPage extends BasePage {
    public SearchBookResultPage(WebDriver driver) {
        super(driver);
    }

    private final By cardOfBook = By.cssSelector("div[data-component-type='s-search-result']");
    private final By headOfJava = By.xpath("//span[contains(text(), 'Head First Java: A Brain-Friendly Guide')]");
    private final By bookTitle = By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']");
    private final By bookAuthor = By.xpath(".//div[@class='a-row']/span[contains(text(), 'by')]/following-sibling::*[1]");
    private final By bookPrice = By.xpath(".//div[@class=\"a-row a-spacing-mini\" and descendant::text()=\"Kindle\"]/div/following-sibling::*/a/span[@class=\"a-price\" and not (following-sibling::span[@class=\"a-size-base a-color-base\" and contains(.//text(), \"to rent\")])]/span[@class] | .//div[@class=\"a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style\" and descendant::text()=\"Kindle\"] /div/following-sibling::*/a/span/span[@class] | .//div[@class=\"a-row a-spacing-mini\" and descendant::text()=\"Board book\"]/div/following-sibling::*/a/span/span[@class]");


    public SearchBookResultPage findParamForJava(List<Book> bookInfoList){

        List<WebElement> bookElements = driver.findElements(cardOfBook);


        for (WebElement bookElement : bookElements) {
            WebElement title = bookElement.findElement(bookTitle);
            WebElement author = bookElement.findElement(bookAuthor);
            WebElement price = bookElement.findElement(By.xpath(".//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']/parent::*"));

            Book book = new Book();

            if(title != null & author != null & price !=null){
                book.setTitle(title.getText());
                book.setAuthor(author.getText());
            }else {
                book.setTitle("null");
                book.setAuthor("null");
            }


            bookInfoList.add(book);

        }

        for (Book book : bookInfoList) {

            System.out.print("Title: " + book.getTitle()+" | ");
            System.out.print("author: " + book.getAuthor()+" | ");
            System.out.println();

        }


        return this;
    }

    public SearchBookResultPage checkThatBookIsPresentAndClick(){
        driver.findElement(headOfJava).click();
        return this;
    }

    public SearchBookResultPage findParamForRuby(List<Book> bookInfoList){
        List<WebElement> bookElements = driver.findElements(cardOfBook);
        for (WebElement bookElement : bookElements) {
            WebElement title = bookElement.findElement(bookTitle);
            WebElement author = bookElement.findElement(bookAuthor);
            WebElement price = bookElement.findElement(bookPrice);

            Book book = new Book();
            if(title != null & author != null & price !=null){
                book.setTitle(title.getText());
                book.setAuthor(author.getText());
                book.setPrice(price.getText());
            }else {
                book.setTitle("null");
                book.setAuthor("null");
                book.setPrice("null");
            }



            bookInfoList.add(book);
        }

        for (Book book : bookInfoList) {

            System.out.print("Title: " + book.getTitle()+" | ");
            System.out.print("author: " + book.getAuthor()+" | ");
            System.out.print("price: " + book.getPrice()+" | ");
            System.out.println();

        }

        return this;
    }

}
