package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage 
{
	//variable declaration
	@FindBy(xpath="//div[text()='My Account']") private WebElement MyAcc;   
	WebDriver driver1;
	
	//step2: initialization
	public PBHomePage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);   
		driver1=driver;
	}
	
	
	public void mouseOverPBHomePageMyAcc() 
	{
		Actions act=new Actions(driver1);
		act.moveToElement(MyAcc).perform();		
	}
}
