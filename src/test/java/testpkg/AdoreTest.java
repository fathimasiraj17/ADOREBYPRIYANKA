package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.AdorePage;
import utilities.ExcelUtilities;


public class AdoreTest {
	
	WebDriver driver;
	String baseurl = "https://www.adorebypriyanka.com/";
	AdorePage ob;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get(baseurl);
		
	}
	
	@BeforeMethod
	public void bfrmthd()
	{
		ob= new AdorePage(driver);
	}
	
	@Test (priority = 1)
	public void signInTest() throws Exception
	{
		String excel = "C:\\Users\\rubys\\Desktop\\Adore.xlsx";
		String Sheet = "Sheet1";
		int rowcount = ExcelUtilities.getrowcount(excel , Sheet);
		for (int i=1;i<=rowcount;i++)
		{
			String email = ExcelUtilities.getcellvalue(excel, Sheet, i, 0);
			String password=ExcelUtilities.getcellvalue(excel, Sheet, i, 1);
			ob.setValues(email, password);
			
		}		
	}
	
	 @Test (priority = 2)
	 public void logoVerification()
		{
		 ob.logo();
		}
	 
	 @Test (priority = 3)
	 public void searchTest()
	 {
		 ob.search();
	 }
	 
	 @Test (priority = 4)
	 public void wishlistTest() throws Exception
	 {
		 Thread.sleep(3000);
		 ob.wishlist();
	 }
	
	@Test (priority = 5)
	 public void menulist() throws Exception
	 {
		Thread.sleep(3000);
		 ob.hamburgerMenu();
	 }
	
	@Test (priority = 6)
	public void linkCountTest()
	{
		ob.linkCount();
	}
	
	@Test (priority = 7)
	public void menuDisplay()
	{
		ob.menuLists();
	}
	

	@Test (priority = 8)
	public void pageScrnsht() throws Exception
	{
		ob.screenshot();
	}
	
	@Test (priority = 9)
	public void logoScreenshot() throws Exception
	{
		ob.logoScrnsht();
	}
	
	

	

}
