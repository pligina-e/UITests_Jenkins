package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import static helpers.Wait.inputText;
import static helpers.Wait.waitThenClick;
import static helpers.Wait.waitUntilVisibleElement;

public class SQLExercisesPage extends BasePage {
    @FindBy(xpath = "(//input[@name='login'])[1]")
    WebElement loginField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "input[name='subm1']")
    WebElement submitButton;
    @FindBy(css = "img[alt='Âûõîä...']")
    WebElement imageButton;

    public SQLExercisesPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Заполнение поля Логин значением {0}, поля Пароль значением {1}")
    public SQLExercisesPage fillFields(String login, String password) {
        inputText(driver, loginField, login);
        inputText(driver, passwordField, password);
        waitThenClick(driver, submitButton);
        return this;
    }

    @Step("Определение наличия кнопки выхода на странице")
    public Boolean presenceOfImageButton() {
        waitUntilVisibleElement(driver, imageButton);
        return imageButton.isDisplayed();
    }
}
