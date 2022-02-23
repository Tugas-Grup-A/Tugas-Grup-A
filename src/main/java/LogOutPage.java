import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class LogOutPage {
    public static WebDriver driver;

    public LogOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id = "react-burger-menu-btn")
    private static WebElement ButtonMenu;

    @FindBy(id = "logout_sidebar_link")
    private static WebElement ButtonLogOut;

    public static void clickButtonMenu(){
        ButtonMenu.click();
    }

    public static void clickButtonLogOut(){
        ButtonLogOut.click();
    }

}
