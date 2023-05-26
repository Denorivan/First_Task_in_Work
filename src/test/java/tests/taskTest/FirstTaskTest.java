package tests.taskTest;

import classes.allPages.pages.ItemPage;
import classes.allPages.pages.SearchBookResultPage;
import classes.allPages.pages.StartingPage;
import classes.entity.Book;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static classes.constants.Constant.UrlVariable.MAIN_PAGE_OF_AMAZON;

public class FirstTaskTest extends BaseTest {

    @Test
    public void Try(){
        startingPage = new StartingPage(driver);
        searchBookResultPage = new SearchBookResultPage(driver);
        itemPage = new ItemPage(driver);
        List<Book> bookInfoList = new ArrayList<>();
        Book book = new Book();

        basePage
                .open(MAIN_PAGE_OF_AMAZON);

        startingPage
                .clickOnSearchDropdownCard()
                .clickInSearchDropdownCardOnBooks()
                .fillingKeywordSearchFild("Java")
                .clickSubmitButtonToSearch();

        searchBookResultPage
                .findParam(bookInfoList)
                .checkThatBookIsPresentAndClick();

        itemPage
                .compareObjects(book, bookInfoList);
    }
}
