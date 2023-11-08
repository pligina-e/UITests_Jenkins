package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TabsPage;

@Epic("Тестирование страницы frames-and-windows.php")
@Feature("При нажатии на ссылку происходит переход на новую открывшуюся вкладку")
public class TabsTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь нажимает на ссылку, чтобы перейти на новую вкладку")
    public final void tabsTest() {
        TabsPage tabsPage = new TabsPage(driver);
        Assert.assertEquals(3, tabsPage.getCountOfOpenTabsHandles(), "Кол-во открытых вкладок не равно трём");
    }
}
