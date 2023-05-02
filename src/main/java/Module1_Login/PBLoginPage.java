package Module1_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage 
{
	//variable declaration
	@FindBy(xpath="//a[text()='Sign in']") private WebElement signIN;   //private WebElement signIN = driver.findElement(By.xpath(""))
	
	
	//step2: initialization
	public PBLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);              //diffclass.nethodname(webDriver, this);
	}
	
	
	public void clickPBLoginPageSignInBtn() 
	{
		signIN.click();
	}
}
