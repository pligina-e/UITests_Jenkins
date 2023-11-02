package tests;

import helpers.PropertyProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setCapabilities() throws MalformedURLException {
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL("http://192.168.1.67:4444"), capabilities);
        driver.get(PropertyProvider.getInstance().getProperty("web.url"));
        tdriver.set(driver);
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterMethod
    public final void afterMethod() {
        driver.quit();
    }
}
