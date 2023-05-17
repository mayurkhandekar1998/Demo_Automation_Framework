package B_Object_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZ_Bank_Manager {

	WebDriver driver;
	public  XYZ_Bank_Manager(WebDriver driver) {
		this.driver = driver;
	}
//	@FindBy(xpath="//button[text()=\"Bank Manager Login\"]") 
//	private WebElement login_Button;
//	@FindBy(xpath="//button[@ng-click=\"addCust()\"]") 
	//private WebElement ADD_Tab;
	@FindBy(xpath="(//input[@type=\"text\"])[1]") 
	private WebElement fname1;
	
	@FindBy(xpath="(//input[@type=\"text\"])[2]") 
	private WebElement lname2;
	
	@FindBy(xpath="(//input[@type=\"text\"])[3]") 
	private WebElement postcode3;
	
	@FindBy(xpath="//button[@type=\"submit\"]") 
	private WebElement addcust;
	

//	public void login() throws InterruptedException {
//		Thread.sleep(2000);
//		login_Button.click();
//		Thread.sleep(2000);
//		ADD_Tab.click();
//	}
	public void register(String fname, String lname, String postcode) throws InterruptedException {
		Thread.sleep(1000);
		fname1.sendKeys(fname);
		Thread.sleep(1000);
		lname2.sendKeys(lname);
		Thread.sleep(1000);
		postcode3.sendKeys(postcode);
		Thread.sleep(1000);
	}
	
	public void add() {
		addcust.click();
	}
	
}
