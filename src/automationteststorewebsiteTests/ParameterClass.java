package automationteststorewebsiteTests;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterClass {
	
	WebDriver driver = new ChromeDriver();
	String MyWebsite = "https://www.automationteststore.com/";
	Random rand = new Random();
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String FirstName, LastName,Email,Address,City,LoginName,ZipCode;
	String Password="Test@123%$#";
	int RandomNumberForEmail = rand.nextInt(223456);
	int RandomNumberForUserName = rand.nextInt(2345671);
	String ExpectedResultForHomeAccess = MyWebsite;
	 boolean ExpectedResultForRegistration = true;
	 boolean ExpectedResultForLogOut = true;
	 Date timeStamp = new Date();
	 //ReadFromDataBase
	 String [] CustomerIDarray = {"103","112","114","119"};
	 int RandomId = rand.nextInt(CustomerIDarray.length);
	 String RandomCustomer = CustomerIDarray[RandomId];
	 String QueryToRead = "select * from customers where customerNumber="+RandomCustomer;
	
	
	public void TheSetUp() throws SQLException {
		
		driver.get(MyWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","abc123");
	}
	
	
	
	 public void ScrollPageAndScreenShot(int TheValueWhereToStop,String screenShotOrder) throws IOException, InterruptedException {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0,arguments[0])",TheValueWhereToStop);
		 Thread.sleep(3000);
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File Myscreenshots = ts.getScreenshotAs(OutputType.FILE);
		 String FileName = timeStamp.toString().replace(":", "-")+screenShotOrder;
		 FileUtils.copyFile(Myscreenshots, new File("src/screenShots/"+FileName+".jpg"));
		 
	 }

}
