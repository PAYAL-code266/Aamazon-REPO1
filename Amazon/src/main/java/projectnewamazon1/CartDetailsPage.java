package projectnewamazon1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDetailsPage {

	
	//private WebElement firstProductName;
	@FindBy (xpath="(//div[@id=\"sc-active-cart\"]//h4//span)[3]")
	private WebElement firstProductName;
	@FindBy (xpath="//div[@id=\"sc-active-cart\"]//div[@class=\"a-section a-spacing-mini\"]//span")
	 private WebElement firstProductPrice;
	
	
	
	public CartDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String getFirstProductName()
	{
		return firstProductName.getText().trim();
	}
		
	public String getFirstProductPrice()
	{
		return firstProductPrice.getText().trim();
	}
}
