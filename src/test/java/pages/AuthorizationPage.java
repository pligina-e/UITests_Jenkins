package pages;

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

    public AuthorizationPage pressMenuButtons() {
        waitThenClick(driver, resourcesButton);
        waitThenClick(driver, practiceSite2Select);
        return this;
    }

    public AuthorizationPage pressImageRegistration() {
        waitThenClick(driver, registrationImage);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return this;
    }

    public AuthorizationPage fillFields(String username, String password) {
        inputText(driver, usernameField, username);
        inputText(driver, passwordField, password);
        inputText(driver, usernameDescriptionField, username);
        waitThenClick(driver, loginButton);
        return this;
    }

    public String getLabelText() {
        waitUntilVisibleElement(driver, successfulLoginLabel);
        return successfulLoginLabel.getText();
    }
}
