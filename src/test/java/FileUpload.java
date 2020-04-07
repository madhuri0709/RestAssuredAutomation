package seleniumtopics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUpload{
	@Test
	public void fileUpload() throws IOException{
		System.setProperty("webdriver.gecko.driver","D:\\AutoIt\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// pass application URL or the path of application which is to be automated
		driver.get("file:///D:/AutoIt/FileUpload.html");
		driver.manage().window().maximize();
		//finding 'Browse' button by using xpath 
		WebElement element = driver.findElement(By.xpath(".//*[@id='1']"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		// normal click is not working , so , have used JavaScript executor
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		/**
		 * Selenium is an open source tool that is designed to automate web-based applications 
		 * on different browsers but to handle window GUI and non HTML popups in application. 
		 * AutoIT is required as these window based activity are not handled by Selenium.
		 */
		
		// "Au3Info_x64.exe" file is used to get the details of windows objects
		
		/** this is the place where autoIt comes to picture
		 *  1 First we need to download 'AUTOIT' and 'AUTOIT EDITOR'
		 *  2 Download from https://www.autoitscript.com/site/autoit/downloads
		 *  3 Install AutoIt and Script editor
		 *  3 refer help section before starting automation
		 *  4 I have used ControlFocus,ControlSetText,ControlClick these methods from Help 
		 *  4 need to write script ,and then save (it will be saved with '.au3' extension)
		 *  5 Right click on above file and click 'Compile Script (x64)' option in order to compile script 
		 *  then below .exe file will be generated
		 *  6 Runtime class is available in 'java.lang' package , by making use of it we can finish file upload 
		 */
		Runtime.getRuntime().exec("D:/AutoIt/FileUpload.exe");
//		driver.close();
	}	
	
}
