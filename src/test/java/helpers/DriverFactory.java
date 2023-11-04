package helpers;

//import com.opera.core.systems.OperaDriver;
import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver testOnMultipleBrowsers(String browser, String grid) throws MalformedURLException {
        if (grid.equals("with grid")) {
            capabilities.setCapability("browserName", browser);
            return new RemoteWebDriver(new URL("http://192.168.1.67:4444"), capabilities);
        } else {
            switch (browser) {
                case "firefox":
                    return new FirefoxDriver();
                case "chrome":
                    return new ChromeDriver();
                case "internet explorer":
                    System.setProperty("webdriver.ie.driver", "C:\\webdrivers\\IEDriverServer.exe");
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setCapability("nativeEvents", false);
                    cap.setCapability("unexpectedAlertBehaviour", "accept");
                    cap.setCapability("ignoreProtectedModeSettings", true);
                    cap.setCapability("disable-popup-blocking", true);
                    cap.setCapability("enablePersistentHover", true);
                    cap.setCapability("ignoreZoomSetting", true);
                    cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                    InternetExplorerOptions options = new InternetExplorerOptions();
                    options.merge(cap);
                    return new InternetExplorerDriver(options);
                case "edge":
                    return new EdgeDriver();
                case "safari":
                    System.setProperty("webdriver.safari.driver", "C:\\webdrivers\\SafariDriver.safariextz");
                    return new SafariDriver();
                case "operablink":
                    System.setProperty("webdriver.opera.driver", "C:\\webdrivers\\operadriver.exe");
                    return new OperaDriver();
                default: return null;
            }
        }
    }
}
