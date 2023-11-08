package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.setTextAlertAndClick;
import static helpers.Wait.waitThenClick;

public class AlertPage extends BasePage {
    @FindBy(css = "a[href='#example-1-tab-2']")
    WebElement inputAlertButton;
    @FindBy(xpath = "//*[contains(text(),'demonstrate')]")
    WebElement demonstrateAlertButton;
    @FindBy(css = "p#demo")
    WebElement resultText;

    public AlertPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликаем по кнопкам для открытия alert. Вводим текст в alert и нажимаем \"Ок\"")
    public void clickOnButtonsAndEnterTextInAlert() {
        waitThenClick(driver, inputAlertButton);
        driver.switchTo().frame(1);
        waitThenClick(driver, demonstrateAlertButton);
        setTextAlertAndClick(driver, "Ivan Ivanov");
    }

    @Step("Запоминаем отображаемый на странице текст")
    public String getTextOnThePage() {
        return resultText.getText();
    }
}
