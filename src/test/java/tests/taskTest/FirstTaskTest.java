package tests.taskTest;

import org.openqa.selenium.By;
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
                .checkThatBookIsPresent()
                .findParamInHeadOfJava2();

    }
}
