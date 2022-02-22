package org.example.LoginSauce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Inventory {
    private static WebDriver driver;
    //pagefactory agar @FindBy dikenali
    public Inventory(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemsName;

    @FindBy(xpath = "//div[.='Sauce Labs Bike Light']")
    private WebElement itemLabs;


    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement clickBackPack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement clickBikeLight;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']/parent::a")
    private WebElement itemCart;

    @FindBy(xpath = "//button[.='Add to cart']/preceding-sibling::div[.='$9.99']")
    private WebElement actual;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement expected;

    public String isActual(){
        return actual.getText();}

    public String isExpected(){
        return expected.getText();
    }



    public boolean isPageDisplayed(){
        itemsName.get(0).isDisplayed();
        return true;
    }
    public void isPageclickable(){itemLabs.click();}


    public void isBackPack(){clickBackPack.click();}

    public void isBikeLight(){clickBikeLight.click();}

    public boolean isCartDisplayed() {
        itemCart.isDisplayed();
        return true;
    }

}
