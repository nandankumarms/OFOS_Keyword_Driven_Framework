package DriverClass;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtility.ExcelLibrary;
import KeywordDriven.Action_Keyword;

public class TestCaseDriverClass extends Action_Keyword{
	static ExtentReports report=new ExtentReports("./Reports/extentreport.html");
	static ExtentTest test;
static	ArrayList<String> keyWord;
	static ArrayList<String> xPath;
	static ArrayList<String> testData;
	static ArrayList<String> testCaseId;
public static void main(String[] args)  {
	
	try {
		testCaseId=ExcelLibrary.readTestCaseID();
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
			
			
	for(int i=0;i<testCaseId.size();i++) {
		test=report.startTest(testCaseId.get(i));
	try {
		keyWord = ExcelLibrary.readKeywords(testCaseId.get(i));
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		xPath = ExcelLibrary.getXpath(testCaseId.get(i));
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		testData = ExcelLibrary.readTestData(testCaseId.get(i));
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int j=0;j<keyWord.size();j++) {
	switch (keyWord.get(j)) {
	case "openBrowser": {
		openBrowser();
		break;
	}
	
	
	case "navigate" : navigate();	
	break;
	
	
	case "clickAction":clickAction(driver.findElement(By.xpath(xPath.get(j))));
	break;
	
	case "enterText": enterText(driver.findElement(By.xpath(xPath.get(j))), testData.get(j));
	break;
	
	
	default: System.out.println("No action present");
	break;
		
	}
	
	}
	test.log(LogStatus.PASS, testCaseId.get(i)+" is completed succesfully");
	driver.quit();
	}
	report.endTest(test);
	report.flush();
	
}
}
