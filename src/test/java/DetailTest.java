
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class DetailTest {
    @Test
    public void firstTest() throws InterruptedException {
        // web driver
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // navigate webapp
        driver.get("https://www.saucedemo.com/");

        // login
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");
        //submit
        WebElement login = driver.findElement(By.id("login-button"));
        login.submit();

        //list
        WebElement list = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]")));
        list.click();

        Thread.sleep(2000);
        WebElement detail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_0_img_link\"]/img")));
        detail.click();

        //WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")));
        //cart.click();

        Thread.sleep(2000);
        WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"back-to-products\"]")));
        back.click();
        //menu
        //WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"react-burger-menu-btn\"]")));
        //option.click();

        //WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
        //logout.click();

        // record
        //assertTrue(elementUN.isDisplayed());

        Thread.sleep(3000);
        // quit test
        driver.quit();

    }
}
