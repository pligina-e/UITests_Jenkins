package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {
    @FindBy(id = "draggable")
    WebElement drag;
    @FindBy(id = "droppable")
    WebElement drop;
    @FindBy(css = "iframe.demo-frame")
    WebElement frame;

    public DroppablePage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Перетаскивание элемента в принимающий")
    public void dragAndDropElement() {
        driver.switchTo().frame(frame);
        new Actions(driver).dragAndDrop(drag, drop).perform();
    }

    @Step("Возвращение текста принимающего элемента")
    public String getTextReceivingElement() {
        return drop.getText();
    }
}
