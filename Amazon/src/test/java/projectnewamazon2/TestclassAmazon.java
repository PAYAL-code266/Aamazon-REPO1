package projectnewamazon2;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import projectnewamazon.RecommendedAccessoriesModule;
import projectnewamazon1.CartDetailsPage;
import projectnewamazon1.HomePage;
import projectnewamazon1.ProductDetails;
import projectnewamazon1.SearchResult;
import projectnewamazon1.SignInpage;

public class TestclassAmazon {
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
  driver.manage().window().maximize();
	Thread.sleep(2000);
driver.get("https://www.amazon.in/");

HomePage homepage=new HomePage(driver);
homepage.clickOnLoginButton();

SignInpage signinpage=new SignInpage(driver);
signinpage.enterEmailorPhoneno("8789539166");
signinpage.clickOnContinue();
signinpage.enterPassword("Admin@123");
signinpage.clickOnSigIn();

homepage=new HomePage(driver);
homepage.enterProductName("mobile");
Thread.sleep(3000);
homepage.clickonFirstSuggestionOption();
homepage.clickOnSearchButton();

SearchResult searchres=new SearchResult(driver);
searchres.clickonselectItem();

//child browser

ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(addr.get(1));

ProductDetails productdetails= new ProductDetails(driver);
String expectedproductname=productdetails.getProductName();
String expectedproductprice=productdetails.getProductPrice();
productdetails.clickonAddtoCart();

Thread.sleep(2000);
RecommendedAccessoriesModule recommend=new RecommendedAccessoriesModule(driver);
recommend.gotoCartPage();

//cart details
CartDetailsPage cartdetails=new CartDetailsPage(driver);
String actualproductname=cartdetails.getFirstProductName();
String actualproductprice=cartdetails.getFirstProductPrice();

if(expectedproductname.equals(actualproductname)&& expectedproductprice.equals(actualproductprice) )
{
System.out.println("pass");

}
else
{
	System.out.println("fail");
}
homepage.clickOnLogOutButton();
driver.quit();











}
}