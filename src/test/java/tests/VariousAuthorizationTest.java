package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AuthorizationPage;

import java.util.List;

@Epic("Тестирование вкладки авторизации")
@Feature("Авторизация")
public class VariousAuthorizationTest extends BaseTest {
    @DataProvider(name = "authorization data")
    public Object[][] createData1() {
        return new Object[][] {
                { "angular", "pass", "description" },
                { "Anne", "12345", "description" },
                { "Tomas", "TomasTomas123", "My name is Tomas" },
        };
    }

    @Test(description = "Авторизация через меню Resources -> Practice Site2", dataProvider = "authorization data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь вводит некорректные данные в поля Username, Password, Description")
    public final void authorizationWithDifferentDataTest(String username, String password, String description) {
        SoftAssert softAssert = new SoftAssert();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.pressMenuButtons();
        softAssert.assertEquals(driver.getTitle(), "Protractor and AngularJS practice - sample website", "Открылась не та страница при нажатии Resources -> Practice Site2");
        authorizationPage.pressImageRegistration();
        softAssert.assertTrue(driver.getTitle().contains("Registration"), "Title страницы не содержит \"Registration\". Страница авторизации не открылась");
        authorizationPage.fillFields(username, password, description);
        softAssert.assertEquals("Username or password is incorrect", authorizationPage.getErrorText(), "Текст ошибки не совпадает с текстом \"Username or password is incorrect\"");
        softAssert.assertAll();
    }
}
