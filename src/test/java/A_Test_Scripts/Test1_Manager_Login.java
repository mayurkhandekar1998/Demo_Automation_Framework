package A_Test_Scripts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import B_Object_POM.XYZ_Bank_Manager;
import C_Utility.Data_Provider_Class;

public class Test1_Manager_Login extends Base_Class {
	@Test(dataProviderClass =Data_Provider_Class.class, dataProvider ="Register Data")
	public void TC1_Add_Customer(String fname, String lname, String postcode ) throws InterruptedException {
					
			Reporter.log("Testcase1 is starting......", true);
			userloggs = report.createTest("Registration of user");
			
			XYZ_Bank_Manager page = PageFactory.initElements(driver, XYZ_Bank_Manager.class);
			
			userloggs.info("Starting application");
			//page.login();
			page.register(fname, lname, postcode);
			
			page.add();
			Alert alt = driver.switchTo().alert();
			alt.accept();
			
			userloggs.pass("Register successfully");
			
			Reporter.log("Testcase1 is completed...", true);			
	
	}

}
