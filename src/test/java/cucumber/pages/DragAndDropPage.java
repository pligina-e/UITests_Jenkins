package cucumber.pages;

import cucumber.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
    @FindBy(id = "draggable")
    WebElement drag;
    @FindBy(id = "droppable")
    WebElement drop;
    @FindBy(css = "iframe.demo-frame")
    WebElement frame;

    public DragAndDropPage(final WebDriver webDriver) {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public void dragAndDropElement() {
        HelperClass.getDriver().switchTo().frame(frame);
        new Actions(HelperClass.getDriver()).dragAndDrop(drag, drop).perform();
    }

    public String getTextReceivingElement() {
        return drop.getText();
    }
}
