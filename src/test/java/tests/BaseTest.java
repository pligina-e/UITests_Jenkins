package tests;

import helpers.DriverFactory;
import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    DriverFactory driverFactory = new DriverFactory();

    @Parameters({"browser", "grid"})
    @BeforeMethod
    public void setUpOnDifferentBrowsers(String browser, String grid) throws MalformedURLException {
        driver = driverFactory.testOnMultipleBrowsers(browser, grid);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        int pageLoadTimeout = Integer.parseInt(PropertyProvider.getInstance().getProperty("page.load.timeout"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
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
