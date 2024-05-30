package pagepkg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdorePage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/a[1]")
	WebElement login;
	
	@FindBy (id = "CustomerEmail")
	WebElement email;
	
	@FindBy (id = "CustomerPassword")
	WebElement password;
	
	@FindBy (xpath = "//*[@id=\"customer_login\"]/p[1]/button")
	WebElement signin;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/a[2]")
	WebElement search;
	
	@FindBy (id = "Search")
	WebElement searchbar;
	
	@FindBy (xpath = "//*[@id=\"CollectionAjaxContent\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/a")
	WebElement item;
	
	@FindBy (xpath = "//*[@id=\"ProductSelect-template--15725863370813__main-6954925981757-option-0\"]/div[4]")
	WebElement colour;
	
	@FindBy (xpath = "//*[@id=\"shopify-block-d8fbc7a6-40d7-424c-afb4-f34ecc5f917c\"]/wishlist-button-block/wk-button/button")
	WebElement wishlist;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/wishlist-link/wk-button/a")
	WebElement viewWL;
	
	@FindBy (xpath = "//*[@id=\"MainContent\"]/wishlist-page/section/div[2]/div/wishlist-product-card/div/form/button")
	WebElement cartbtn;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[1]/div/button")
	WebElement menu;
	
	@FindBy (xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div[2]/ul[1]/li[9]/a")
	WebElement bracelet;
	
	@FindBy (xpath = "//*[@id=\"SortBy\"]")
	WebElement dropdown;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/a[1]")
	WebElement account;
	
	@FindBy (xpath = "//*[@id=\"NavDrawer\"]/div/div[2]/ul")
	WebElement menulist;
	
	@FindBy (xpath = "//*[@id=\"NavDrawer\"]/div/div[1]/div/div[2]/button")
	WebElement closemenu;
	
	@FindBy (xpath = "//*[@id=\"SiteHeader\"]/div[1]/div/div[2]/div/a/image-element[1]/img")
	WebElement logoimage;
	
	
	public AdorePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setValues(String mail, String pswd)
	{
		login.click();
		email.clear();
		email.sendKeys(mail);
		password.clear();
		password.sendKeys(pswd);
		signin.click();
		
	}
	
	public void logo()
	{
		boolean logo = driver.findElement(By.xpath("//*[@id=\"SiteHeader\"]/div[1]/div/div[2]/div/a/image-element[1]/img")).isDisplayed();
		if(logo)
		{
			System.out.println("logo present");
		}
		else
		{
			System.out.println("logo absent");
		}
	}
	
	public void search()
	{
		search.click();
		searchbar.click();
		searchbar.sendKeys("choker");
		searchbar.submit();
	}
	
	public void wishlist()
	{
		item.click();
		colour.click();
		wishlist.click();
		wishlist.click();
		System.out.println("wishlist");
		viewWL.click();
		cartbtn.click();	
	}
	
	
	public void hamburgerMenu()
	{
		menu.click();
		bracelet.click();
		dropdown.click();
		Select brclt = new Select(dropdown);
		brclt.selectByValue("best-selling");
			
	}
	
	public void linkCount()
	{
		account.click();
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links: "+li.size());
	}
	
	public void menuLists()
	{
		menu.click();
		List<WebElement> li=menulist.findElements(By.tagName("li"));
		for(WebElement menus:li)
		{
		String s = menus.getText();
		if(!s.isEmpty())
		{
		System.out.println(s.trim());
		}
		}
		closemenu.click();
	}
	
	public void screenshot() throws Exception
	{
		viewWL.click();
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/WLpage.png"));
		
	}
	
	public void logoScrnsht() throws Exception
	{
		File logosrc = logoimage.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(logosrc, new File("./Screenshot/logo.png"));
	}
	
	

}
