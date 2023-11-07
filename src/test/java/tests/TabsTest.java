package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TabsPage;

@Epic("“естирование страницы frames-and-windows.php")
@Feature("ѕри нажатии на ссылку происходит переход на новую открывшуюс€ вкладку")
public class TabsTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("ѕользователь нажимает на ссылку, чтобы перейти на новую вкладку")
    public final void tabsTest() {
        TabsPage tabsPage = new TabsPage(driver);
        Assert.assertEquals(3, tabsPage.getCountOfOpenTabsHandles(), " ол-во открытых вкладок не равно трЄм");
    }
}
