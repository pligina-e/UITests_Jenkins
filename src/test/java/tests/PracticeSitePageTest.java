package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeSitePage;

public class PracticeSitePageTest extends BaseTest {
    @Test(description = "Переход по меню: Resources -> Practice Site1")
    public final void openPracticeSite1PageTest() {
        PracticeSitePage practiceSitePage = new PracticeSitePage(driver);
        practiceSitePage.pressMenuButtons();
        Assert.assertEquals(driver.getTitle(),"Welcome to the Test Site", "Открылась не та страница");
    }
}
