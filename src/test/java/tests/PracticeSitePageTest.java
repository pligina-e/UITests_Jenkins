package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeSitePage;

public class PracticeSitePageTest extends BaseTest {
    @Test(description = "Переход по меню: Resources -> Practice Site1")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование главной страницы")
    @Feature("Переход по меню на другую страницу")
    @Story("Пользователь кликает на главной странице на меню \"Resources->Practice Site1\", чтобы открылась соответствующая страница")
    public final void openPracticeSite1PageTest() {
        PracticeSitePage practiceSitePage = new PracticeSitePage(driver);
        practiceSitePage.pressMenuButtons();
        Assert.assertEquals(driver.getTitle(),"Welcome to the Test Site", "Открылась не та страница");
    }
}
