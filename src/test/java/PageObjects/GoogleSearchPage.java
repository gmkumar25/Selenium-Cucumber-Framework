package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchPage {
	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	/**  ****** All the Locators goes here ******  **/
	By txtBox_Search = By.name("q");
	By link_Agree = By.xpath("//*[text()='I agree']");
	By link_All_Results = By.xpath("//span[text()='All']");



	/**  ****** All the Methods goes here ******  
	 * @throws InterruptedException **/
	public void open_GoogleSearchPage_URL(String Url) throws InterruptedException {
		driver.get(Url);
		Boolean flag = driver.findElement(link_Agree).isDisplayed();
		if(flag==true) {
			driver.findElement(link_Agree).click();
		}
		Thread.sleep(2000);
	}
	
	public void search_data(String s) {
		driver.findElement(txtBox_Search).sendKeys(s);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void verify_SearchPage_is_Launched() {
		driver.findElement(link_All_Results).isDisplayed();
	}
	
}
