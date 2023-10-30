package tests;

import helpers.TestAllureListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.PracticeSitePage;

@Listeners({TestAllureListener.class})
@Epic("Тестирование главной страницы")
@Feature("Переход по меню на другую страницу")
public class PracticeSitePageTest extends BaseTest {
    @Test(description = "Переход по меню: Resources -> Practice Site1")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь кликает на главной странице на меню \"Resources->Practice Site1\", чтобы открылась соответствующая страница")
    public final void openPracticeSite1PageTest() {
        PracticeSitePage practiceSitePage = new PracticeSitePage(driver);
        practiceSitePage.pressMenuButtons();
        Assert.assertEquals(driver.getTitle(),"Welcome to the Test Site1", "Открылась не та страница");
    }

    @Test(description = "Переход по меню: Resources -> Practice Site2")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь кликает на главной странице на меню \"Resources->Practice Site2\", чтобы открылась соответствующая страница")
    public final void openPracticeSite2PageTest() {
        AuthorizationPage practiceSite2Page = new AuthorizationPage(driver);
        practiceSite2Page.pressMenuButtons();
        Assert.assertEquals(driver.getTitle(), "Несуществующий title", "Открылась не та страница");
    }
}
