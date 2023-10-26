package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static helpers.Wait.waitUntilVisibleAllElements;
import static helpers.Wait.waitUntilVisibleElement;

public class HomePage extends BasePage {
    @FindBy(css = "header.site-header")
    WebElement header;
    @FindBy(xpath = "(//div[contains(@class,'ast-main-header-wrap')])[1]")
    WebElement horizontalMenu;
    @FindBy(xpath = "//li[contains(@class,'elementor-inline-item')]")
    List<WebElement> contactDetailsOfHeader;
    @FindBy(css = "div.site-header-section ul#ast-hf-menu-1 > li")
    List<WebElement> linksOfHorizontalMenu;
    @FindBy(xpath = "(//h1[contains(@class, 'elementor-heading-title')])[1]")
    WebElement certificationBlockLabel;
    @FindBy(css = "section.elementor-element-5b4952c1")
    WebElement certificationBlock;
    @FindBy(xpath = "(//h2[@class='elementor-image-box-title'])[1]")
    WebElement coursesBlockLabel;
    @FindBy(xpath = "//div[contains(@class,'elementor-element-c50f9f0')]")
    WebElement coursesBlock;
    @FindBy(id = "colophon")
    WebElement footer;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean presenceOfHeader() {
        waitUntilVisibleElement(driver, header);
        return header.isDisplayed();
    }

    public Boolean presenceOfMenu() {
        waitUntilVisibleElement(driver, horizontalMenu);
        return horizontalMenu.isDisplayed();
    }

    public ArrayList<String> getContactDetailsOfHeader() {
        waitUntilVisibleAllElements(driver, contactDetailsOfHeader);
        ArrayList<String> listOfLinksHeader = contactDetailsOfHeader.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksHeader;
    }

    public ArrayList<String> getLinksOfHorizontalMenu() {
        waitUntilVisibleAllElements(driver, linksOfHorizontalMenu);
        ArrayList<String> listOfLinksMenu = linksOfHorizontalMenu.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksMenu;
    }

    public String titleOfCertificationBlock() {
        waitUntilVisibleElement(driver, certificationBlockLabel);
        return certificationBlockLabel.getText();
    }

    public Boolean presenceOfCertificationBlock() {
        waitUntilVisibleElement(driver, certificationBlock);
        return certificationBlock.isDisplayed();
    }

    public String titleOfCoursesBlock() {
        waitUntilVisibleElement(driver, coursesBlockLabel);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", coursesBlockLabel);
        return coursesBlockLabel.getText();
    }

    public Boolean presenceOfCoursesBlock() {
        waitUntilVisibleElement(driver, coursesBlock);
        return coursesBlock.isDisplayed();
    }

    public Boolean presenceOfFooter() {
        waitUntilVisibleElement(driver, footer);
        return footer.isDisplayed();
    }

    public HomePage goToElement() {
        Actions actions = new Actions(driver);
        waitUntilVisibleElement(driver, coursesBlock);
        actions.moveToElement(coursesBlock).perform();
        return this;
    }
}
