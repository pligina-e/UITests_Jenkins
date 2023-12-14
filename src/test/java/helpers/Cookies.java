package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Cookies extends BasePage {
    public Cookies(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Создание в проекте файла с Cookie")
    public void createFileWithCookie(WebDriver webDriver, String cookieName) {
        File file = new File("Cookies.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            fileWrite.write(webDriver.manage().getCookieNamed(cookieName).getValue());
            fileWrite.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Чтение cookie из файла проекта и добавление их на сайт для аутентификации")
    public void addCookieForLogin(WebDriver webDriver, String cookieName) {
        webDriver.manage().deleteAllCookies();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Cookies.data"));
            Cookie cookie = new Cookie(cookieName, reader.readLine());
            webDriver.manage().addCookie(cookie);
        } catch(Exception e) {
            e.printStackTrace();
        }
        webDriver.navigate().refresh();
    }
}
