package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicAuthPage;

@Epic("Тестирование страницы authentication/#showExample10")
@Feature("При вводе корректных данных в promt dialog появляется картинка с соответствующими данными")
public class BasicAuthTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь нажимает на кнопку, вводит корректные данные, чтобы авторизироваться и увидеть картинку с введенными данными")
    public final void basicAuthorizationTest() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        Assert.assertTrue(basicAuthPage.presenceOfImage(), "Картинка не появилась. Возможно, были указаны неверные данные => вход на сайт не выполнен");
    }
}
