package zeropark.ui;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;

@Category(UiTests.class)
public abstract class BaseUITest {
    static final String LOGIN = System.getProperty("demoLogin", "demo@zeropark.com");
    static final String PASSWORD = System.getProperty("demoPassword", "demo123");


    @BeforeClass
    public static void setup() {
        Configuration.browser = System.getProperty("browserName", "firefox");
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "30000"));
    }
}
