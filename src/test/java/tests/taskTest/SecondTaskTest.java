package tests.taskTest;

import classes.allPages.pages.ItemPage;
import classes.allPages.pages.SearchBookResultPage;
import classes.allPages.pages.StartingPage;
import classes.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static classes.constants.Constant.UrlVariable.MAIN_PAGE_OF_AMAZON;
import static classes.constants.Constant.UrlVariable.RUBY_SEARCH;

public class SecondTaskTest extends BaseTest {

    @Test
    public void Try(){
        startingPage = new StartingPage(driver);
        searchBookResultPage = new SearchBookResultPage(driver);
        itemPage = new ItemPage(driver);
        List<Book> bookInfoList = new ArrayList<>();
        Book book = new Book();
        Book expectedBook = new Book("Head First Java: A Brain-Friendly Guide", "Kathy Sierra");

        basePage
                .open(RUBY_SEARCH);

        /*startingPage
                .clickOnSearchDropdownCard()
                .clickInSearchDropdownCardOnBooks()
                .fillingKeywordSearchFild("Ruby")
                .clickSubmitButtonToSearch();*/

        searchBookResultPage
                .findParamForRuby(bookInfoList);



    }
}
