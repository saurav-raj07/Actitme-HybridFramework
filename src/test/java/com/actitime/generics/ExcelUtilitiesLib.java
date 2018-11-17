package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilitiesLib {

	String value;

	public String readData(String sheet, int row, int cell)
			throws IOException, EncryptedDocumentException, InvalidFormatException {

		FileInputStream fis = new FileInputStream(
				new File("./src/test/resources/ActitimeHybridFramework_TestData.xlsx"));
		Workbook wbf = WorkbookFactory.create(fis);
		value = wbf.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		fis.close();
		return value;
	}
}
