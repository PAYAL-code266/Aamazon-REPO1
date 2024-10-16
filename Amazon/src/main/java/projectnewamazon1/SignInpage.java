package projectnewamazon1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInpage {

	
	@FindBy (xpath="//input[@id=\"ap_email\"]")
	private WebElement emailOrPhone;
	@FindBy (xpath="//input [@id='continue']")
	private WebElement continueButton;
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement passWord;
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signIn;
	
	public SignInpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterEmailorPhoneno(String userId)
	{
		emailOrPhone.sendKeys(userId);
	}
		
	public void enterPassword(String userpassword)
	{
		passWord.sendKeys( userpassword);
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public void clickOnSigIn()
	{
		signIn.click();
	}
}
