package StepDefinitions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObjects.GoogleSearchPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class GoogleSearchSteps {

	WebDriver driver = null;
	String URL; 
	Scenario scenario;
	GoogleSearchPage googlesearchpage;
	
	@Before
	public void browserSetup(Scenario scenario) throws IOException {
		this.scenario = scenario;
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\AppConfig.properties"));
		Properties properties = new Properties();
		properties.load(reader);
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		URL = properties.getProperty("URL");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		googlesearchpage = new GoogleSearchPage(driver);
	}

	@After
	public void tear_Down() {
		driver.close();
		driver.quit();
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}

	@Given("I access the Google page")
	public void i_access_the_google_page() throws Exception {
	    try {
	    	googlesearchpage.open_GoogleSearchPage_URL(URL);
			scenario.log("User provided a valid URL");
		} catch (Exception e) {
			scenario.log("User provided an invalid URL");
			throw new Exception("****  This step has failed - Please refer to the bottom for screenshot  ****");
		}
	}

	@When("I search for some data")
	public void i_search_for_some_data() throws Exception {
		try {
			googlesearchpage.search_data("Automation");
			scenario.log("User successfully entered a text to search");
		} catch (Exception e) {
			scenario.log("User could not enter a text to search");
			throw new Exception("****  This step has failed - Please refer to the bottom for screenshot  ****");
		}
	}

	@Then("I should see the results")
	public void i_should_see_the_results() throws Exception {
		try {
			googlesearchpage.verify_SearchPage_is_Launched();
			scenario.log("User successfully landed in search results page");
			
		} catch (Exception e) {
			scenario.log("User could not land in search results page");
			throw new Exception("****  This step has failed - Please refer to the bottom for screenshot  ****");
		}
	}

	@When("I search for some {string}")
	public void i_search_for_some(String string) throws Exception {
		try {
			googlesearchpage.search_data(string);
			scenario.log("User successfully entered a text to search");
		} catch (Exception e) {
			scenario.log("User could not enter a text to search");
			throw new Exception("****  This step has failed - Please refer to the bottom for screenshot  ****");
		}
	}
	
}
