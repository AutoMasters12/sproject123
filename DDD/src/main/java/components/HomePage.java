package components;

import org.openqa.selenium.By;

public class HomePage {
	
	public void verifyHomePage() {
		boolean res=Browser.driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		if(res) {
			System.out.println("i am into home page");
		}else {
			System.out.println("i am not into home page");
		}
	}

}
