import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class SortingTest {
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
    public void verifyDropDownLisAToZ() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        HomePage homePage = new HomePage(driver);
        homePage.dropdownAtoZ();
        Assert.assertTrue(homePage.dropdownAtoZ());


    }
    @Test
    public void verifyDropDownListZToA() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        HomePage homePage = new HomePage(driver);
        homePage.dropdownZtoA();
        Assert.assertTrue(homePage.dropdownZtoA());


    }
    @Test
    public void verifyDropDownListLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        HomePage homePage = new HomePage(driver);
        homePage.dropdownlowtohigh();
        Assert.assertTrue(homePage.dropdownlowtohigh());


    }

    @Test
    public void verifyDropDownListHighToLow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        HomePage homePage = new HomePage(driver);
        homePage.dropdownhightolow();
        Assert.assertTrue(homePage.dropdownhightolow());


    }
}
