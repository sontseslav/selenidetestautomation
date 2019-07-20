package p900;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URI;

public class WebDriverTestBase {
    protected RemoteWebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        String runType = "selenoid";
        switch (runType) {
            case ("local"):
                Configuration.browser = "chrome";
                break;
            case ("selenoid"):
//                DesiredCapabilities browser = new DesiredCapabilities();
//                browser.setBrowserName("chrome");
//                browser.setVersion("75");
//                browser.setCapability("enableVNC", true);
//                driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), browser);
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("69.0");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", false);

                RemoteWebDriver driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        capabilities
                );
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
