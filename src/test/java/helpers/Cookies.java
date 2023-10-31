package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Cookies extends BasePage {
    public Cookies(final WebDriver webDriver) {
        super(webDriver);
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
}
