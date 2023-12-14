package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MultiformPage;

@Epic("Тестирование страницы multiform")
@Feature("Наличие скролла и возможность убирания фокуса")
public class FormProfileTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь может убрать фокус с поля ввода, а также увидеть скролл на странице")
    public final void multiformPageTest() {
        MultiformPage multiformPage = new MultiformPage(driver);
        Assert.assertTrue(multiformPage.presenceOfScroll(), "Скролл не найден на странице");
        Assert.assertTrue(multiformPage.removeFocus(), "Фокус не убран с поля ввода");
    }
}
