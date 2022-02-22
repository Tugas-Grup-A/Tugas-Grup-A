
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void negativeCase1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("admin");
        loginPage.setPassword("password");
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match any user in this service"));
    }

    @Test
    public void negativeCase2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("admin");
        loginPage.setPassword("");
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Password is required"));
    }

    @Test
    public void successfullyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.dropdownAtoZ());

    }
    
}


