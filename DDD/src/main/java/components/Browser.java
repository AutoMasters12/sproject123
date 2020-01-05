package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;
	
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		Options opt = driver.manage();
		Window win = opt.window();
		win.maximize();
	}
	
	public void launchApp() {
		driver.get("https://www.google.com/");
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
