package projectnewamazon1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDetailsPage {

	
	//private WebElement firstProductName;
	@FindBy (xpath="//span[text()='Samsung 108 cm (43 inches) D Series Crystal 4K Vivid Ultra HD…']")
	private WebElement firstProductName;
	
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
