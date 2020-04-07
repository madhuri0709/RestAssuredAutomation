package seleniumtopics;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DownloadFile {
	@Test
	public void downloadFile() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:/AutoIt/chromedriver.exe");
		// this is the path where I am interested to save all my downloads using chrome , instead of default download folder
		String downloadFilePath = "D:/AutoIt";
		
		// this is the real time example of map , where we are passing key and value pair to do some settings in chrome
		HashMap<String, Object> chromePref = new  HashMap<String, Object>();
		//below line suppress download dialogs when we download 
		chromePref.put("profile.default_content_Settings.popups", 0);
		chromePref.put("download.default_directory", downloadFilePath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePref);
		
		// setting chrome driver with above options
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://skpatro.github.io/demo/links/");
		driver.findElement(By.xpath("//input[@value='Download']")).click();
		Thread.sleep(5000);
		
		

 
	}

}
