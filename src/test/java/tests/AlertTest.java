package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

@Epic("Тестирование страницы alert.php")
@Feature("При нажатии на кнопку появляется alert, который обрабатывает текст и отображает на странице")
public class AlertTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь нажимает на кнопку, вводит текст в alert и нажимает кнопку \"Ок\", чтобы введенный им текст отобразился на странице")
    public final void alertTest() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickOnButtonsAndEnterTextInAlert();
        Assert.assertEquals("Hello Ivan Ivanov! How are you today?", alertPage.getTextOnThePage(), "Текст не отобразился на странице");
    }
}
