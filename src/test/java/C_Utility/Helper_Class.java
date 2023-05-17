package C_Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper_Class {
	
	public static String TakeScreenshots(WebDriver driver) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\" + Getcurrent_date_time() + ".png";
		
		FileUtils.copyFile(src, new File(screenshotpath));
		return screenshotpath;
	}
	
	public static String  Getcurrent_date_time() {

		DateFormat formatdate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_");

		Date currentdate = new Date();
		return formatdate.format(currentdate);

	}

}
