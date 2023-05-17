package A_Test_Scripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import C_Utility.Confi_Data_Provider;
import C_Utility.Helper_Class;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base_Class {

	public static WebDriver driver;
	public Confi_Data_Provider data;
	public ExtentReports report;
	public ExtentSparkReporter sparkreport;
	public ExtentTest userloggs;

	@BeforeSuite
	public void Before_Suite() {
		Reporter.log("Setting up extent reports, config data file", true);
	    data = new Confi_Data_Provider();
	    sparkreport = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/"+ Helper_Class.Getcurrent_date_time() + "xyxbank.html"));
        report = new ExtentReports();
        report.attachReporter(sparkreport);
        Reporter.log("Settup finished" , true);
	}

	@BeforeClass
	public void Browser_Launch() {
		Reporter.log("Setting up Browser", true);
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options1);



		Reporter.log("Browser set up finished", true);

		driver.get(data.GetURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void screenShot(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				System.out.println("Successfully captured a screenshot");
				Reporter.log("Screenshot has been taken", true);
				userloggs.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper_Class.TakeScreenshots(driver)).build());
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

		report.flush();
		Reporter.log("Reports has been stored", true);
	}

	@AfterClass
	public void Browser_Close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
