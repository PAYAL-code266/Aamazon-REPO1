package projectnewamazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendedAccessoriesModule {
@FindBy(xpath="//button[@id=\"a-autoid-1-announce\"]")	
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




