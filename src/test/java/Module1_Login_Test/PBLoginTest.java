package Module1_Login_Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.PBHomePage;
import Module1_Login.PBLoginPage;
import Module1_Login.PBMobNumPage;
import Module1_Login.PBMyAccPage;
import Module1_Login.PBMyProfilePage;
import Module1_Login.PBPasswordPage;

public class PBLoginTest extends BaseClass
{
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPasswordPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBMyProfilePage myProfile;
	int TCID;
	
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{			
	    initializeBrowser();
	    
	     login=new PBLoginPage(driver);
		 mobNum=new PBMobNumPage(driver);
		 pwd=new PBPasswordPage(driver);
		 home=new PBHomePage(driver);
		 myAcc=new PBMyAccPage(driver);
		 myProfile=new PBMyProfilePage(driver);		
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.clickPBLoginPageSignInBtn();
		Thread.sleep(2000);
		mobNum.inpPBMobNumPageMobNum(UtilityClass.getPFData("UN"));
		mobNum.clickPBMobNumPageSignInWithPWD();
		Thread.sleep(2000);
		pwd.inpPBPasswordPageMobPWD(UtilityClass.getPFData("PWD"));
		pwd.clickPBPasswordPagesignInBtn();
		Thread.sleep(3000);
	}
		
	@Test
	public void verifyPN() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=101;
		home.mouseOverPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		myProfile.switchToChildWindow();
		String actPN = myProfile.getPBMyProfilePageFullName();
		String expPN= UtilityClass.getTD(0, 2);
		Assert.assertEquals(actPN, expPN,"Failed: both results are diff- ");	
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
	}
	
	
		
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
}
