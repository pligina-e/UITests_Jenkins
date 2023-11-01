package tests;

import helpers.PropertyProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void init(final ITestContext context) {
        String browserName = PropertyProvider.getInstance().getProperty("browser.name");
        int pageLoadTimeout = Integer.parseInt(PropertyProvider.getInstance().getProperty("page.load.timeout"));
        WebDriverManager.getInstance(browserName).setup();

        switch (browserName) {
            case "chrome" -> driver = new ChromeDriver(new ChromeOptions()
                    .addArguments("--remote-allow-origins=*")
                    .addArguments("--disable-gpu")
                    .addArguments("--start-maximized")
                    .addArguments("enable-automation")
                    .addArguments("--no-sandbox")
                    .addArguments("--disable-extensions")
                    .addArguments("--dns-prefetch-disable")
            );
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        context.setAttribute("driver", driver);
        String webUrl = PropertyProvider.getInstance().getProperty("profile.form.web.url");
        tdriver.set(driver);
        driver.get(webUrl);
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterMethod
    public final void afterMethod() {
        driver.quit();
    }
}
