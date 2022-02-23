import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LogOutTest {
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
        public void SuccessfullyLogOut() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLogin();
            HomePage homePage = new HomePage(driver);
            Assert.assertTrue(homePage.dropdownAtoZ());
            LogOutPage logOutPage = new LogOutPage(driver);
            LogOutPage.clickButtonMenu();
            LogOutPage.clickButtonLogOut();




        }





    }



