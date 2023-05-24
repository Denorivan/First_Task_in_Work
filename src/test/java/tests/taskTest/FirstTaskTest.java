package tests.taskTest;

import classes.allPages.pages.HeadFirst;
import classes.allPages.pages.JavaPage;
import classes.allPages.pages.MainPage;
import classes.entity.Book;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static classes.constants.Constant.UrlVariable.MAIN_PAGE_OF_AMAZON;

public class FirstTaskTest extends BaseTest {

    @Test
    public void Try(){
        mainPage = new MainPage(driver);
        javaPage = new JavaPage(driver);
        headFirst = new HeadFirst(driver);

        basePage.open(MAIN_PAGE_OF_AMAZON);
        List<Book> bookInfoList = new ArrayList<>();
        Book book = new Book();

        mainPage
                .clickToChoose()
                .chooseBooks()
                .fillAreaWithText("Java")
                .clickButtonToFind();
        javaPage
                .findParam(bookInfoList)
                .checkThatBookIsPresentAndClick();

        headFirst
                .compareObjects(book,bookInfoList);
    }
}
