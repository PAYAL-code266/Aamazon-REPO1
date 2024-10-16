package projectnewamazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendedAccessoriesModule {
@FindBy(xpath="//a[@id=\"nav-cart\"]")	
private WebElement cartButton;

public RecommendedAccessoriesModule (WebDriver driver)

{
	PageFactory.initElements(driver,this);
}
public void gotoCartPage()
{
	cartButton.click();
}
}




