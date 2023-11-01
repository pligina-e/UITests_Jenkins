package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.waitUntilVisibleElement;

public class MultiformPage extends BasePage {
    @FindBy(css = "input.ng-valid")
    WebElement nameField;

    public MultiformPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Определение наличия скролла на странице")
    public boolean presenceOfScroll() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String scrollHeight = jsExecutor.executeScript("return document.body.clientHeight - document.documentElement.clientHeight").toString();
        return Integer.parseInt(scrollHeight) > 0;
    }

    @Step("Поставить и убрать фокус из поля ввода")
    public boolean removeFocus() {
        waitUntilVisibleElement(driver, nameField);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].focus()", nameField);
        jsExecutor.executeScript("arguments[0].blur()", nameField);
        boolean presenceOfFocus = (Boolean) jsExecutor.executeScript("return document.activeElement != document.querySelector('input.ng-valid')");
        return presenceOfFocus;
    }
}
