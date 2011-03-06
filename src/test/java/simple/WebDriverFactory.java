package simple;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class WebDriverFactory {

    private static WebDriver driver;
    private static final String FIREFOX_DRIVER = "org.openqa.selenium.firefox.FirefoxDriver";

    public static WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        }
        throw new RuntimeException("trying to call methods on a unitialized driver");
    }

    public static void initializeBrowser() {
        if (driver == null) {
            try {
                String driverClass = System.getProperty("driver.class", FIREFOX_DRIVER);
                Constructor<?> ctor = Class.forName(driverClass).getConstructor();
                driver = (WebDriver) ctor.newInstance();
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        WebDriverFactory.tearDown();
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize webdriver", e);
            }
        }

    }
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }




}