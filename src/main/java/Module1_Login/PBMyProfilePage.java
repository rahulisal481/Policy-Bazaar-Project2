package Module1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyProfilePage 
{
	//variable declaration
	@FindBy(xpath="//input[@name='personName']") private WebElement fullName;   
	WebDriver driver1;
	
	//step2: initialization
	public PBMyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);              //diffclass.nethodname(webDriver, this);
		driver1=driver;
	}
	
	
	public void switchToChildWindow()
	{
		Set<String> allIds = driver1.getWindowHandles();   //{mainPageId , childWindowID}
		ArrayList<String> al=new ArrayList<String>(allIds);      //{mainPageId(0) , childWindowID(1)}
		String childWindowID = al.get(1);
		driver1.switchTo().window(childWindowID);
	}
	
	
	public String getPBMyProfilePageFullName() 
	{
		String actText = fullName.getAttribute("value");
		return actText;
	}
}
