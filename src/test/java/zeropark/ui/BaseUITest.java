package zeropark.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

@Category(UiTests.class)
public abstract class BaseUITest {
    static final String LOGIN = System.getProperty("demoLogin", "demo@zeropark.com");
    static final String PASSWORD = System.getProperty("demoPassword", "demo123");

    @Rule
    public BrowserWebDriverContainer browser =
            new BrowserWebDriverContainer()
                    .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("./target/"))
                    .withDesiredCapabilities(getCapabilities());

    @BeforeClass
    public static void setupAll() {
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "30000"));
    }

    public DesiredCapabilities getCapabilities() {
        String browserName = System.getProperty("browserName", "chrome");
        if (browserName.equalsIgnoreCase("firefox")) {
            return DesiredCapabilities.firefox();
        }
        return DesiredCapabilities.chrome();
    }

    @Before
    public void setup() {
        RemoteWebDriver driver = browser.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
