package KeywordDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Keyword {
	public static WebDriver driver;
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("./Drivers/chrome/chrome.exe");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	
	public static void navigate() {
		driver.get("http://elftestingserver/domain/Online_Food_Ordering_System/");
	}
	
	public static void clickAction(WebElement element) {
		element.click();
	}
	
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void main(String[] args) {
		openBrowser();
	}
}
