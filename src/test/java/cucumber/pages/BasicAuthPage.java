package cucumber.pages;

import cucumber.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Wait.waitThenClick;
import static helpers.Wait.waitUntilVisibleElement;

public class BasicAuthPage {
    @FindBy(id = "displayImage")
    WebElement displayImageButton;
    @FindBy(id = "downloadImg")
    WebElement downloadImg;

    public BasicAuthPage() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public void clickOnButton() {
        waitThenClick(HelperClass.getDriver(), displayImageButton);
    }

    public Boolean presenceOfImage() {
        waitUntilVisibleElement(HelperClass.getDriver(), downloadImg);
        return downloadImg.isDisplayed();
    }
}
