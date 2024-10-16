package projectnewamazon1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	@FindBy (xpath="")
private WebElement productName;
	@FindBy (xpath="")
private WebElement productPrice;
	@FindBy (xpath="//button[@id='a-autoid-5-announce']")
private WebElement addToCart;
	@FindBy (xpath="//input[@id='buy-now-button']")
private WebElement buyNow;
	
private WebDriver driver;

public ProductDetails(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
	
}

public void gotoFrame()
{
 driver.switchTo().frame(buyNow);
}

public String getProductName()
{
	return productName.getText().trim();
}
	
public String getProductPrice()
{
	return productPrice.getText().trim();
}
public void clickonAddtoCart()
{
	addToCart.click();
}
	
public void clickonBuynow()
{
	buyNow.click();
}



}
