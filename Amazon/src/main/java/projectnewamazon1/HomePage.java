package projectnewamazon1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement accountList;
	@FindBy (xpath="//span[text()='Sign in']")
	private WebElement signIn;
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy (xpath="//input[@id=\"twotabsearchtextbox\"]")
	private WebElement searchTextbox;
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	@FindBy (xpath="(//div[@id='nav-flyout-searchAjax']//div[@role='button'])[1]")
	private WebElement suggestionOption;

	private Actions action;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		action=new Actions(driver);
		
	}
	
	public void clickonAccountList()
	{
		accountList.click();
		System.out.println("hello i m new");
	}
	
public void clickOnLoginButton()
{
	action.moveToElement(accountList).moveToElement(signIn).click().build().perform();
}

public void clickOnLogOutButton()
{
	action.moveToElement(accountList).moveToElement(signOut).click().build().perform();
}

public void enterProductName(String productName) {
	searchTextbox.sendKeys(productName);
}
public void clickOnSearchButton()
{
	searchButton.click();
}
public void clickonFirstSuggestionOption()
{
	suggestionOption.click();
}
}
