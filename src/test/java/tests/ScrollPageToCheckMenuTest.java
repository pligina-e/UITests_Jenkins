package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class ScrollPageToCheckMenuTest extends BaseTest {
    @Test(description = "Проверка того, что при скроллинге отображается основное меню в шапке на главной")
    public final void scrollPageToCheckMenuTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        List<String> actualListOfMenuLinks = List.of("Home", "All Courses", "Video Tutorial", "Resources", "Careers", "Lifetime Membership", "Blog", "Forum", "Member Login");
        ArrayList<String> expectedListOfMenuLinks;
        softAssert.assertTrue(driver.getTitle().contains("Way2Automation"),"Title страницы не содержит \"Way2Automation\". Открылась не главная страница");
        homePage.goToElement();
        expectedListOfMenuLinks = homePage.getLinksOfHorizontalMenu();
        softAssert.assertTrue(homePage.presenceOfMenu(), "Горизонтальное меню не найдено на странице");
        softAssert.assertEquals(actualListOfMenuLinks, expectedListOfMenuLinks, "Горизонтальное меню некорректно (ссылки не совпадают)");
        softAssert.assertAll();
    }
}
