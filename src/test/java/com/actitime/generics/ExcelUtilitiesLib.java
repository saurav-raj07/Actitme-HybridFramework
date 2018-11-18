package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilitiesLib {

	public static String readData(String sheet, int row, int cell) {

		String value = null;
		
		try {
			//FileInputStream fis = new FileInputStream(new File("./src/test/resources/TestData/ActitimeHybridFramework_TestData.xlsx"));
			FileInputStream fis = new FileInputStream(new File("C:/Users/Saurav/Desktop/ActitimeHybridFramework_TestData.xlsx"));
			Workbook wbf = WorkbookFactory.create(fis);
			value = wbf.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			fis.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}
}
