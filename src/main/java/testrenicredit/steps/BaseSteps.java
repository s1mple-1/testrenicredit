package testrenicredit.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testrenicredit.utils.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;

    public static void setUp() {
        Properties properties = TestProperties.getInstance().getProperties();

        String browser = properties.getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driver"));
                webDriver = new ChromeDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", properties.getProperty("driver"));
                webDriver = new OperaDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("driver"));
                webDriver = new FirefoxDriver();
                break;
        }

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        webDriverWait = new WebDriverWait(webDriver, 10);

        actions = new Actions(webDriver);

        webDriver.get("https://rencredit.ru");
    }

    public static void tearDown() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
