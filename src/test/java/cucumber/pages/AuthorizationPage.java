package cucumber.pages;

import cucumber.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Wait.inputText;
import static helpers.Wait.waitThenClick;
import static helpers.Wait.waitUntilVisibleElement;

public class AuthorizationPage {
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
    @FindBy(css = "div.alert-danger")
    WebElement errorLoginLabel;

    public AuthorizationPage(final WebDriver webDriver) {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public void pressMenuButtonResources() {
        waitThenClick(HelperClass.getDriver(), resourcesButton);
    }

    public void pressMenuButtonPracticeSite() {
        waitThenClick(HelperClass.getDriver(), practiceSite2Select);
    }

    public void pressImageRegistration() {
        waitThenClick(HelperClass.getDriver(), registrationImage);
        for (String winHandle : HelperClass.getDriver().getWindowHandles()) {
            HelperClass.getDriver().switchTo().window(winHandle);
        }
    }

    public void fillFields(String username, String password, String description) {
        inputText(HelperClass.getDriver(), usernameField, username);
        inputText(HelperClass.getDriver(), passwordField, password);
        inputText(HelperClass.getDriver(), usernameDescriptionField, description);
    }

    public void pressLoginButton() {
        waitThenClick(HelperClass.getDriver(), loginButton);
    }

    public String getLabelText() {
        waitUntilVisibleElement(HelperClass.getDriver(), successfulLoginLabel);
        return successfulLoginLabel.getText();
    }

    public String getErrorText() {
        waitUntilVisibleElement(HelperClass.getDriver(), errorLoginLabel);
        return errorLoginLabel.getText();
    }
}
