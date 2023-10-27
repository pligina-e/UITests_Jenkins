package pages;

import io.qameta.allure.Step;
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

    @Step("Определение наличия хидера на странице")
    public Boolean presenceOfHeader() {
        waitUntilVisibleElement(driver, header);
        return header.isDisplayed();
    }

    @Step("Определение наличия горизонтального меню на странице")
    public Boolean presenceOfMenu() {
        waitUntilVisibleElement(driver, horizontalMenu);
        return horizontalMenu.isDisplayed();
    }

    @Step("Запоминание реквизитов для связи хидера")
    public ArrayList<String> getContactDetailsOfHeader() {
        waitUntilVisibleAllElements(driver, contactDetailsOfHeader);
        ArrayList<String> listOfLinksHeader = contactDetailsOfHeader.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksHeader;
    }

    @Step("Запоминание ссылок горизонтального меню")
    public ArrayList<String> getLinksOfHorizontalMenu() {
        waitUntilVisibleAllElements(driver, linksOfHorizontalMenu);
        ArrayList<String> listOfLinksMenu = linksOfHorizontalMenu.stream()
                .map(item->item.getText())
                .collect(Collectors.toCollection(ArrayList::new));
        return listOfLinksMenu;
    }

    @Step("Запоминание текста над блоком сертификации")
    public String titleOfCertificationBlock() {
        waitUntilVisibleElement(driver, certificationBlockLabel);
        return certificationBlockLabel.getText();
    }

    @Step("Определение наличия блока сертификации на странице")
    public Boolean presenceOfCertificationBlock() {
        waitUntilVisibleElement(driver, certificationBlock);
        return certificationBlock.isDisplayed();
    }

    @Step("Перемещение к блоку с курсами и запоминание текста над блоком")
    public String titleOfCoursesBlock() {
        waitUntilVisibleElement(driver, coursesBlockLabel);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", coursesBlockLabel);
        return coursesBlockLabel.getText();
    }

    @Step("Определение наличия блока с курсами на странице")
    public Boolean presenceOfCoursesBlock() {
        waitUntilVisibleElement(driver, coursesBlock);
        return coursesBlock.isDisplayed();
    }

    @Step("Определение наличия футера на странице")
    public Boolean presenceOfFooter() {
        waitUntilVisibleElement(driver, footer);
        return footer.isDisplayed();
    }

    @Step("Перемещение к определенному элементу на странице")
    public HomePage goToElement() {
        Actions actions = new Actions(driver);
        waitUntilVisibleElement(driver, coursesBlock);
        actions.moveToElement(coursesBlock).perform();
        return this;
    }
}
