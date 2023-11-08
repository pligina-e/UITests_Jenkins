package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.waitThenClick;
import static helpers.Wait.waitUntilVisibleElement;

public class BasicAuthPage extends BasePage {
    @FindBy(id = "displayImage")
    WebElement displayImageButton;
    @FindBy(id = "downloadImg")
    WebElement downloadImg;

    public BasicAuthPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Определение наличия картинки на странице")
    public Boolean presenceOfImage() {
        waitThenClick(driver, displayImageButton);
        waitUntilVisibleElement(driver, downloadImg);
        return downloadImg.isDisplayed();
    }
}
