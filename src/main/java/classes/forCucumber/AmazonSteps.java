package classes.forCucumber;



import classes.entity.Book;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Selenide.*;


public class AmazonSteps {
    List<Book> bookInfoList = new ArrayList<>();
    Book book = new Book();
    private final SelenideElement choosingBooks = $x("//option[@value='search-alias=stripbooks-intl-ship']");
    private final SelenideElement allChoose = $x("//div[@class='nav-search-scope nav-sprite']");
    private final SelenideElement textContainer = $(By.id("twotabsearchtextbox"));
    private final SelenideElement finderButton = $(By.id("nav-search-submit-button"));
    private final SelenideElement headOfJava = $x("//span[contains(text(), 'Head First Java: A Brain-Friendly Guide')]");

    @When("Click on dropdown card")
    public void dropdownClick() {
        allChoose.click();
    }

    @And("Choose books")
    public void booksClick(){
        choosingBooks.click();
    }
    @And("Enter {string} in searching field")
    public void enterJava(String keyword){
        textContainer.sendKeys(keyword);
    }

    @And("Press button to search")
    public void pressButtonToSearch(){
        finderButton.click();
    }

    @And("Take all books param from the received page")
    public void getParamOfBooks(){
        ElementsCollection elements = $$("div[data-component-type='s-search-result']");

        List<SelenideElement> bookElements = elements.stream().toList();
        for (SelenideElement bookElement:bookElements){
            SelenideElement title = bookElement.$(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
            SelenideElement author = bookElement.$(By.xpath(".//div[@class='a-row']/span[contains(text(), 'by')]/following-sibling::*[1]"));
            Book book = new Book();
            if(title != null & author != null){
                book.setTitle(title.getText());
                book.setAuthor(author.getText());
            }else {
                book.setTitle("null");
                book.setAuthor("null");
            }
            bookInfoList.add(book);
        }
    }

    @And("Find particular book and click")
    public void findBookHeadFirstAndClick(){
        headOfJava.click();
    }

    @Then("Check that the book is on the list {string} by {string}")
    public boolean compareObjects(String title, String author) {
        book =new Book(title, author);
        for (Book book1: bookInfoList){
            if (    book1.getTitle().contains(book.getTitle())
                    && book1.getAuthor().contains(book.getAuthor())
            )
            {
                System.out.println();
                System.out.print(book1.getTitle()+" | ");
                System.out.print(book1.getAuthor()+" | ");
                System.out.println();
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
