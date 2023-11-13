package cucumber.pages;

import cucumber.utils.HelperClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static helpers.Wait.waitUntilVisibleAllElements;
import static helpers.Wait.waitUntilVisibleElement;

public class PresenceElementsPage {
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

    public PresenceElementsPage(final WebDriver webDriver) {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public Boolean presenceOfHeader() {
        waitUntilVisibleElement(HelperClass.getDriver(), header);
        return header.isDisplayed();
    }

    public Boolean presenceOfMenu() {
        waitUntilVisibleElement(HelperClass.getDriver(), horizontalMenu);
        return horizontalMenu.isDisplayed();
    }

    public ArrayList<String> getContactDetailsOfHeader() {
        waitUntilVisibleAllElements(HelperClass.getDriver(), contactDetailsOfHeader);
        ArrayList<String> listOfLinksHeader = contactDetailsOfHeader.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksHeader;
    }

    public ArrayList<String> getLinksOfHorizontalMenu() {
        waitUntilVisibleAllElements(HelperClass.getDriver(), linksOfHorizontalMenu);
        ArrayList<String> listOfLinksMenu = linksOfHorizontalMenu.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksMenu;
    }

    public String titleOfCertificationBlock() {
        waitUntilVisibleElement(HelperClass.getDriver(), certificationBlockLabel);
        return certificationBlockLabel.getText();
    }

    public Boolean presenceOfCertificationBlock() {
        waitUntilVisibleElement(HelperClass.getDriver(), certificationBlock);
        return certificationBlock.isDisplayed();
    }

    public String titleOfCoursesBlock() {
        waitUntilVisibleElement(HelperClass.getDriver(), coursesBlockLabel);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", coursesBlockLabel);
        return coursesBlockLabel.getText();
    }

    public Boolean presenceOfCoursesBlock() {
        waitUntilVisibleElement(HelperClass.getDriver(), coursesBlock);
        return coursesBlock.isDisplayed();
    }

    public Boolean presenceOfFooter() {
        waitUntilVisibleElement(HelperClass.getDriver(), footer);
        return footer.isDisplayed();
    }

    public void goToElement() {
        Actions actions = new Actions(HelperClass.getDriver());
        waitUntilVisibleElement(HelperClass.getDriver(), coursesBlock);
        actions.moveToElement(coursesBlock).perform();
    }
}
