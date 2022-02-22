import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    @FindBy(xpath = "//option[@value=\"az\"]")
    private WebElement az;

    @FindBy(xpath = "//option[@value=\"za\"]")
    private WebElement za;

    @FindBy(xpath = "//option[@value=\"lohi\"]")
    private WebElement lohi;

    @FindBy(xpath = "//option[@value=\"hilo\"]")
    private WebElement hilo;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    private WebElement search;

    public boolean dropdownAtoZ(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Name (A to Z)");
        return az.isDisplayed();

    }
    public boolean dropdownZtoA(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Name (Z to A)");
        return za.isDisplayed();

    }
    public boolean dropdownlowtohigh(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Price (low to high)");
        return lohi.isDisplayed();
    }
    public boolean dropdownhightolow(){
        Select select = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        select.selectByVisibleText("Price (high to low)");
        return hilo.isDisplayed();
    }
}
