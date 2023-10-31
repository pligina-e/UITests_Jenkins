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
    @FindBy(css = "img[alt='Выход...']")
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

    @Step("Создание в проекте файла с Cookie")
    public void createFileWithCookie() {
        File file = new File("Cookies.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter BuffWrite = new BufferedWriter(fileWrite);
            for(Cookie cookie : driver.manage().getCookies()) {
                BuffWrite.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure()));
                BuffWrite.newLine();
            }
            BuffWrite.close();
            fileWrite.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Чтение cookie из файла проекта и добавление их на сайт для аутентификации")
    public void addCookieForLogin() {
        driver.manage().deleteAllCookies();
        try {
            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String strline;
            while((strline=buffReader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    String sDate = token.nextToken();
                    boolean isSecure = Boolean.getBoolean(token.nextToken());
                    Date expiry = null;
                    if(!(sDate).equals("null")) {
                        expiry = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy", Locale.ENGLISH).parse(sDate);
                    }
                    Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    driver.manage().addCookie(cookie);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
    }

    @Step("Определение наличия кнопки выхода на странице")
    public Boolean presenceOfImageButton() {
        waitUntilVisibleElement(driver, imageButton);
        return imageButton.isDisplayed();
    }
}
