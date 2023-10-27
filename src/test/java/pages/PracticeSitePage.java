package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.waitThenClick;

public class PracticeSitePage extends BasePage {
    @FindBy(id = "menu-item-27617")
    WebElement resourcesButton;
    @FindBy(id = "menu-item-27618")
    WebElement practiceSite1Select;

    public PracticeSitePage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажатие кнопок в горизонтальном меню для перехода на другую страницу")
    public PracticeSitePage pressMenuButtons() {
        waitThenClick(driver, resourcesButton);
        waitThenClick(driver, practiceSite1Select);
        return this;
    }
}
