package tests;

import helpers.Cookies;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SQLExercisesPage;

@Epic("Тестирование главной страницы сайта www.sql-ex.ru")
@Feature("Авторизация")
public class SQLExercisesLoginTest extends BaseTest {
    @Test(description = "Авторизация на сайте www.sql-ex.ru")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь вводит данные в поля Логин и Пароль, затем нажимает на кнопку Войти, чтобы авторизироваться")
    public final void loginTest() {
        SQLExercisesPage exercisesPage = new SQLExercisesPage(driver);
        Cookies cookies = new Cookies(driver);
        exercisesPage.fillFields("pligina-e", "1234554321999");
        cookies.createFileWithCookie(driver, "PHPSESSID");
        Assert.assertTrue(exercisesPage.presenceOfImageButton(), "Авторизация не прошла успешно. Возможно, введены некорректные данные");
    }

    @Test(description = "Авторизация на сайте www.sql-ex.ru")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация с помощью cookie")
    public final void loginWithCookieTest() {
        SQLExercisesPage exercisesPage = new SQLExercisesPage(driver);
        Cookies cookies = new Cookies(driver);
        cookies.addCookieForLogin(driver, "PHPSESSID");
        Assert.assertTrue(exercisesPage.presenceOfImageButton(), "Авторизация не прошла успешно. Возможно, cookie неправильно загрузились на сайт");
    }
}
