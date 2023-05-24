package tests.taskTest;

import classes.entity.Book;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static classes.constants.Constant.UrlVariable.MAIN_PAGE_OF_AMAZON;

public class FirstTaskTest extends BaseTest {

    @Test
    public void Test(){
        List<String> bookInfoList = new ArrayList<>();
        basePage.open(MAIN_PAGE_OF_AMAZON);

        mainPage
                .clickToChoose()
                .chooseBooks()
                .fillAreaWithText()
                .clickButtonToFind()
                .findAllBooksInPage(bookInfoList)
                .checkThatBookIsPresentAndClick();

    }

    @Test
    public void Try(){
        basePage.open(MAIN_PAGE_OF_AMAZON);
        List<Book> bookInfoList = new ArrayList<>();
        Book book = new Book();
        mainPage
                .clickToChoose()
                .chooseBooks()
                .fillAreaWithText()
                .clickButtonToFind();
        javaPage
                .findParam(bookInfoList)
                .checkThatBookIsPresentAndClick();


        headFirst
                .compareObjects(book,bookInfoList);


    }
}
