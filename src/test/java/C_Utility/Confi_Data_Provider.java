package C_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Confi_Data_Provider {

	Properties pro;

	public Confi_Data_Provider() {

		File s = new File("./Configuration/Config.properties");

		try {
			FileInputStream fil = new FileInputStream(s);
			pro = new Properties();
			pro.load(fil);

		} catch (FileNotFoundException e) {

			System.out.println("File not found");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String GetURL() {

		return pro.getProperty("URL");
	}

}
