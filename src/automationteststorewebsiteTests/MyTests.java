package automationteststorewebsiteTests;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTests extends ParameterClass {
	
	
	
	@BeforeTest
	public void SetUp() throws SQLException {
		
		TheSetUp();
		
	}
	
	@Test(priority = 1)
	public void HomepageAccessibilityTest() {
		
//	check The homepage loads completely, displaying all primary elements such as navigation menus, banners, and featured products.
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedResultForHomeAccess);
	
	}
	
	@Test(priority = 2)
	public void UserRegistrationTest() throws SQLException, InterruptedException, IOException {
		//To go to Register Form 
		WebElement LoginOrRegisterBtn = driver.findElement(By.linkText("Login or register"));
		LoginOrRegisterBtn.click();
		WebElement ContinueBtnToRegister = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueBtnToRegister.click();
		
		//Fill Mandatory Fields
		 WebElement firstNameField = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		 WebElement lastNameField = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		 WebElement emailField = driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
		 WebElement addressField = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		 WebElement cityField = driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
		 WebElement zoneDropdown = driver.findElement(By.id("AccountFrm_zone_id"));
		 WebElement postcodeField = driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']"));
		 WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='AccountFrm_country_id']"));
		 WebElement usernameField = driver.findElement(By.xpath("//input[@id='AccountFrm_loginname']"));
		 WebElement passwordField = driver.findElement(By.xpath("//input[@id='AccountFrm_password']"));
		 WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='AccountFrm_confirm']"));
		 WebElement PolicyAgreementBtn = driver.findElement(By.id("AccountFrm_agree"));
		 WebElement ContinueBtn = driver.findElement(By.xpath("//button[@title='Continue']"));
		 
		 stmt = con.createStatement();
		 rs = stmt.executeQuery(QueryToRead);
		 
		 while (rs.next()) {
			 FirstName = rs.getString("contactFirstName").trim();
			 LastName = rs.getString("contactLastName").trim();
			 Email = FirstName+LastName+RandomNumberForEmail+"@gmail.com";
			 Address = rs.getString("addressLine1");
			 City = rs.getString("city");
			 ZipCode = rs.getString("postalCode");
		 }
		 
		 firstNameField.sendKeys(FirstName);
		 lastNameField.sendKeys(LastName);
		 emailField.sendKeys(Email);
		 ScrollPageAndScreenShot(100,"1");
		 
		 addressField.sendKeys(Address);
		 cityField.sendKeys(City);
		 postcodeField.sendKeys(ZipCode);
		//For Country 
		 //The country input first because there is UI false
		 Select selectedCountry = new Select(countryDropdown);
		 selectedCountry.selectByIndex(3);
		 Thread.sleep(3000);
		 //For Region 
		 Select selectedRegion = new Select (zoneDropdown);
		 selectedRegion.selectByIndex(2);
		 ScrollPageAndScreenShot(600, "2");
		 
		 
		 LoginName = FirstName+LastName+RandomNumberForUserName;
		 usernameField.sendKeys(LoginName);
		 passwordField.sendKeys(Password);
		 confirmPasswordField.sendKeys(Password);
		 ScrollPageAndScreenShot(1000, "3");
		 
		 PolicyAgreementBtn.click();
		 ContinueBtn.click();
		 
		
		 Assert.assertEquals(driver.getPageSource().contains("Your Account Has Been Created!"), ExpectedResultForRegistration);
		 
		 WebElement contenueBtnAfterCreation = driver.findElement(By.cssSelector(".btn.btn-default.mr10"));
		 contenueBtnAfterCreation.click();
	}
	
	@Test(priority = 4)
	public void UserLoginTest() {
		WebElement LoginOrRegisterBtn = driver.findElement(By.linkText("Login or register"));
		LoginOrRegisterBtn.click();
		//Elements
		WebElement UserNameField = driver.findElement(By.id("loginFrm_loginname"));
		WebElement PasswordField = driver.findElement(By.id("loginFrm_password"));
		WebElement LogInBtn = driver.findElement(By.xpath("//button[@title='Login']"));
		//Actions
		UserNameField.sendKeys(LoginName);
		PasswordField.sendKeys(Password);
		LogInBtn.click();
		//Assertion
		Assert.assertEquals(driver.getPageSource().contains("Welcome back"), true);
		
	}
	
	@Test(priority = 3)
	public void LogOutTest () {
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/logout");
		//assertion
		Assert.assertEquals(driver.getPageSource().contains("Account Logout"), ExpectedResultForLogOut);
		//Continue LogOut
		WebElement ContinueBtnToLogOut = driver.findElement(By.xpath("//a[@title='Continue']"));
		ContinueBtnToLogOut.click();
	}
	
	@Test(priority = 5)
	public void ProductSearchTest() {
		WebElement SearchField = driver.findElement(By.id("filter_keyword"));
		SearchField.sendKeys("Shampoo");
		SearchField.sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		List<WebElement> results = driver.findElements(By.className("prdocutname"));
		Assert.assertEquals(results.size()>0, true);
	}
	
	@Test(priority = 6)
	public void FilteringSearchResultsTest() throws IOException, InterruptedException {
		WebElement SortDropDown = driver.findElement(By.id("sort"));
		Select SelectedResult = new Select(SortDropDown);
		SelectedResult.selectByIndex(3);
		
		ScrollPageAndScreenShot(450, "4");
	}
	
	@Test(priority = 7 , enabled = false)
	public void ViewingProductDetailsTest() throws IOException, InterruptedException {
		WebElement HomeBtn = driver.findElement(By.linkText("Home"));
		HomeBtn.click();
		WebElement theProduct = driver.findElement(By.className("thumbnail"));
		theProduct.click();
		ScrollPageAndScreenShot(100, "5");
	}
	
	@Test(priority = 8)
	public void  AddingProductstoCartTest() throws InterruptedException {
		WebElement HomeBtn = driver.findElement(By.linkText("Home"));
		HomeBtn.click();
		for(int i=0 ; i<4 ; i++) {
			//Stale found element "Dynamic Element "
			 List<WebElement> products = driver.findElements(By.cssSelector(".thumbnail img"));
			 products.get(i).click();
			driver.findElement(By.xpath("//a[@class='cart']")).click();
			driver.navigate().to("https://automationteststore.com/");
		}
	}
	
	@Test(priority = 9)
	public void ViewingAndModifyingtheShoppingCart() throws IOException, InterruptedException {
		driver.navigate().to("https://automationteststore.com/index.php?rt=checkout/cart");
		WebElement UpdateQuantityFeild = driver.findElement(By.id("cart_quantity52"));
		UpdateQuantityFeild.clear();
		UpdateQuantityFeild.sendKeys("3");
		WebElement UpdateBtn = driver.findElement(By.id("cart_update"));
		UpdateBtn.click();
		ScrollPageAndScreenShot(300, "6");
	}
	
	@Test(priority = 10)
	public void CheckOutTest() throws InterruptedException {
		WebElement CheckOutBtn = driver.findElement(By.id("cart_checkout1"));
		CheckOutBtn.click();
		WebElement ConfarimOrder = driver.findElement(By.id("checkout_btn"));
		ConfarimOrder.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getPageSource().contains(" Your Order Has Been Processed!"), true);
	}
	
	@Test (priority = 11)
	public void ViewingOrderHistory() {
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/history");
		List<WebElement> result = driver.findElements(By.className("contentpanel"));
		Assert.assertEquals(result.size()>0, true);
		}
	
	@Test(priority = 12)
	public void ManagingAccountInformationTest() throws InterruptedException {
		
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/edit");
		WebElement telephoneField = driver.findElement(By.id("AccountFrm_telephone"));
		telephoneField.sendKeys("0788757648");
		WebElement ContinueBtn = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueBtn.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getPageSource().contains( "Success: Your account has been successfully updated."), true);
	}
	
	@Test (priority = 13 ,enabled = false)
	public void SubmittingProductReviewsTest() {
		//Just a manual Testing (captcha) 
	}
	
	@Test (priority = 14)
	public void NewsletterSubscriptionTest() throws IOException, InterruptedException {
		WebElement SubsicribeField = driver.findElement(By.id("appendedInputButton"));
		SubsicribeField.sendKeys(Email);
		WebElement SubsicribBtn = driver.findElement(By.xpath("//button[normalize-space()='Subscribe']"));
		SubsicribBtn.click();
		WebElement ContinueBtn = driver.findElement(By.xpath("//i[@class='fa fa-check fa']"));
		ContinueBtn.click();
		ScrollPageAndScreenShot(100, "7");
	}

	
	@AfterTest
	public void afterfinishtheTest() {
		
		driver.close();
	}
}
