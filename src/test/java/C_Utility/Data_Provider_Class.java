package C_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Data_Provider_Class {
	
	@DataProvider (name ="Register Data")
	public String[][] getdata() throws EncryptedDocumentException, IOException {
		
		FileInputStream excel = new FileInputStream("./Test_Data/ExcelData1.xlsx");
		
		Sheet a = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		int rowno = a.getLastRowNum();
		int cellno = a.getRow(0).getLastCellNum();
		
		String data[][] = new String[rowno][cellno];
		for(int i=0; i<rowno; i++) {
			for(int j=0; j<cellno; j++) {
				DataFormatter format = new DataFormatter();
			data[i][j]	 = format.formatCellValue(a.getRow(i+1).getCell(j));
				
				
			}
		}return data;
		
	}


}
