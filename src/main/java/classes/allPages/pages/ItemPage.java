package classes.allPages.pages;

import classes.allPages.base.BasePage;
import classes.entity.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean compareObjects(Book book, List<Book> bookList) {
        String title = driver.findElement(By.id("productTitle")).getText();
        String author = driver.findElement(By.xpath("//a[contains(text(), 'Kathy Sierra')]")).getText();
        String price = driver.findElement(By.xpath("//a[@id=\"a-autoid-3-announce\"]/span[@class=\"a-color-secondary\"]")).getText().replaceAll(" (.*)", "");


        /*book = new Book(title, author);*/

        book = new Book(title, author);
        for (Book book1 : bookList) {
            if (    book1.getTitle().contains(book.getTitle())
                    && book1.getAuthor().contains(book.getAuthor())
            )
            {
                System.out.println();
                System.out.print(book1.getTitle()+" | ");
                System.out.print(book1.getAuthor()+" | ");
                System.out.println("Object is presenting in list");
                System.out.print(book.getTitle()+" | ");
                System.out.print(book.getAuthor()+" | ");

                return true;
            } else {
                System.out.println();
                System.out.print(book.getTitle()+" | ");
                System.out.print(book.getAuthor()+" | ");
                System.out.println("Object is staying out in list");
                return false;
            }
        }
        System.out.println("Something went wrong ur param to compare: ");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());


        return false;
    }
}
