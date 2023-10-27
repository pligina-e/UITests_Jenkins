package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.inputText;
import static helpers.Wait.waitThenClick;
import static helpers.Wait.waitUntilVisibleElement;

public class AuthorizationPage extends BasePage {
    @FindBy(id = "menu-item-27617")
    WebElement resourcesButton;
    @FindBy(id = "menu-item-27619")
    WebElement practiceSite2Select;
    @FindBy(xpath = "//img[@alt='Registration']")
    WebElement registrationImage;
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "formly_1_input_username_0")
    WebElement usernameDescriptionField;
    @FindBy(xpath = "//button[contains(@class,'btn-danger')]")
    WebElement loginButton;
    @FindBy(css = "h1.ng-scope")
    WebElement successfulLoginLabel;

    public AuthorizationPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажатие кнопок в горизонтальном меню для перехода на другую страницу")
    public AuthorizationPage pressMenuButtons() {
        waitThenClick(driver, resourcesButton);
        waitThenClick(driver, practiceSite2Select);
        return this;
    }

    @Step("Нажатие на кнопку-картинку и переход на открывшуюся вкладку")
    public AuthorizationPage pressImageRegistration() {
        waitThenClick(driver, registrationImage);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return this;
    }

    @Step("Заполнение поля Username значением {0}, поля Password значением {1}, поля User description значением {0}")
    public AuthorizationPage fillFields(String username, String password) {
        inputText(driver, usernameField, username);
        inputText(driver, passwordField, password);
        inputText(driver, usernameDescriptionField, username);
        waitThenClick(driver, loginButton);
        return this;
    }

    @Step("Запоминание текста на странице после успешной авторизации")
    public String getLabelText() {
        waitUntilVisibleElement(driver, successfulLoginLabel);
        return successfulLoginLabel.getText();
    }
}
