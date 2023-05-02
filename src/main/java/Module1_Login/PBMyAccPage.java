package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage 
{
	//variable declaration
	@FindBy(xpath="//span[text()=' My profile ']") private WebElement MyProfile;   
	
	
	//step2: initialization
	public PBMyAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);              //diffclass.nethodname(webDriver, this);
	}
	
	
	public void clickPBMyAccPageMyProfile() 
	{
		MyProfile.click();
	}
}
