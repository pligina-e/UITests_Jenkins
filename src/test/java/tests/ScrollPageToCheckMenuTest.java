package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class ScrollPageToCheckMenuTest extends BaseTest {
    @Test(description = "Проверка того, что при скроллинге отображается основное меню в шапке на главной")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Тестирование главной страницы")
    @Feature("При скроллинге отображается основное меню в шапке")
    @Story("Меню отображается в шапке, когда пользователь скроллит главную страницу")
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