package ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static ArrayList<String> readKeywords(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./TestCaseFile/FlatFile.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet(sheetName);
		ArrayList<String> keywords=new ArrayList<String>();
		int row=sheet.getPhysicalNumberOfRows();
		for(int i=1;i<row;i++) {
			String keyword= sheet.getRow(i).getCell(5).toString();
			keywords.add(keyword);
		}
		return keywords;
	}
	
	
	public static ArrayList<String> getXpath(String sheetName) throws EncryptedDocumentException, IOException {

	FileInputStream fis=new FileInputStream("./TestCaseFile/FlatFile.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	
	Sheet sheet=book.getSheet(sheetName);
	ArrayList<String> xPaths=new ArrayList<String>();
	int row=sheet.getPhysicalNumberOfRows();
	
	for(int i=1;i<row;i++) {
		String keyword= sheet.getRow(i).getCell(5).toString();
		String xPath="";
		try {
			if(sheet.getRow(i).getCell(6).toString()!=null) {
		xPath= sheet.getRow(i).getCell(6).toString();
			}
		}catch (Exception e) {
			System.out.println("Can not read null data");
		}
		xPaths.add(xPath);
	}
	return xPaths;
}
	
	public static ArrayList<String> readTestData(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./TestCaseFile/FlatFile.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet(sheetName);
		ArrayList<String> data=new ArrayList<String>();
		int row=sheet.getPhysicalNumberOfRows();
		
		for(int i=1;i<row;i++) {
			
			String testData="";
			try {
				if(sheet.getRow(i).getCell(4).toString()!=null) {
			testData= sheet.getRow(i).getCell(4).toString();
				}
			}catch (Exception e) {
				System.out.println("Can not read null data");
			}
			data.add(testData);
		}
		return data;
	}
	
	
	
	
	public static ArrayList<String> readTestCaseID() throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./TestCaseFile/TestCaseId.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet("testCaseName");
		ArrayList<String> testCaseID=new ArrayList<String>();
		int row=sheet.getPhysicalNumberOfRows();
		
		for(int i=1;i<row;i++) {
			
			String id="";
			try {
				
			id= sheet.getRow(i).getCell(0).toString();
				
			}catch (Exception e) {
				System.out.println("Can not read null data");
			}
			testCaseID.add(id);
		}
		return testCaseID;
	}
	
}
