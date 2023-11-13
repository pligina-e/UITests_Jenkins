package cucumber.utils;

import helpers.DriverFactory;
import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class HelperClass {
    private static HelperClass helperClass;
    private static WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    private HelperClass() throws MalformedURLException {
        int pageLoadTimeout = Integer.parseInt(PropertyProvider.getInstance().getProperty("page.load.timeout"));
        String browserName = PropertyProvider.getInstance().getProperty("browser.name");
        String grid = PropertyProvider.getInstance().getProperty("grid.presence");
        driver = driverFactory.testOnMultipleBrowsers(browserName, grid);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() throws MalformedURLException {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
        helperClass = null;
    }
}
