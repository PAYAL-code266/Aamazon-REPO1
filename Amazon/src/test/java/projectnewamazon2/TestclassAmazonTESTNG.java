package projectnewamazon2;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projectnewamazon.RecommendedAccessoriesModule;
import projectnewamazon1.CartDetailsPage;
import projectnewamazon1.HomePage;
import projectnewamazon1.ProductDetails;
import projectnewamazon1.SearchResult;
import projectnewamazon1.SignInpage;

public class TestclassAmazonTESTNG {
	private WebDriver driver;
	private HomePage homepage;
	private SignInpage signinpage;
	private SearchResult searchres;
	private ProductDetails productdetails;
	private RecommendedAccessoriesModule recommend;
    private CartDetailsPage cartdetails;
    
    @BeforeClass
    void launchdriver() throws InterruptedException
    {
    	 driver=new ChromeDriver();
    	  driver.manage().window().maximize();
    		Thread.sleep(2000);
    	//driver.get("https://www.amazon.in/");
    }
    @BeforeMethod
    void loginamazon()
    {
    	driver.get("https://www.amazon.in/");
    	HomePage homepage=new HomePage(driver);
    	homepage.clickOnLoginButton();

    	SignInpage signinpage=new SignInpage(driver);
    	signinpage.enterEmailorPhoneno("7219751552");
    	signinpage.clickOnContinue();
    	signinpage.enterPassword("Test@12345");
    	signinpage.clickOnSigIn();
    }
    @Test
    void verifyaddtocart() throws InterruptedException
    {
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
    	
    	Assert.assertEquals(actualproductname, expectedproductname);
    	Assert.assertEquals(actualproductprice, expectedproductprice);
    }
    @AfterMethod
    void logoutfromamazon()
    {
    	homepage.clickOnLoginButton();
    }
    
    @AfterClass
    void closedbrowser()
    {
    	driver.quit();
    }
}


