package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPasswordPage
{
	@FindBy(xpath = "//input[@id='central-login-password']") private WebElement pwd;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInBtn;
	
	
	public PBPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
		
	 public void inpPBPasswordPageMobPWD(String password) 
	 {
		 pwd.sendKeys(password);
	 }
	 
	 public void clickPBPasswordPagesignInBtn() 
	 {
		 signInBtn.click();
	 }

}
