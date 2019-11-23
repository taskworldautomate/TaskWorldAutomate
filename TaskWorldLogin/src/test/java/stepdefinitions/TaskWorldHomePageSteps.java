package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.LocatorRepo;
import helper.WebDriverHelper;

/**
 * This Class consists of the steps to execute from the Feature file
 * 
 * @author souvikghosh
 *
 */
public class TaskWorldHomePageSteps {

	private static final Logger LOG = LoggerFactory.getLogger(TaskWorldHomePageSteps.class);
	WebDriver driver = WebDriverHelper.initiateDriver();;
	LocatorRepo locatorRepo = new LocatorRepo();

	WebDriverWait wait = new WebDriverWait(driver, 15);

	@Given("User Navigates to Home Page and Logs in")
	public void user_Navigates_to_Home_Page_and_Logs_in() throws InterruptedException {

		WebDriverHelper.openURL(driver);

		driver.findElement(locatorRepo.username).sendKeys(locatorRepo.loginUserName);
		driver.findElement(locatorRepo.password).sendKeys(locatorRepo.loginPassword);
	
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(locatorRepo.loginBtn));

		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locatorRepo.loginBtn)).click(driver.findElement(locatorRepo.loginBtn));
		builder.perform();

		// If automated login to the page is not allowed, tryin login via Google
		if (driver.findElements(locatorRepo.newProjButtonBox).size() == 0) 
		{	
			driver.findElement(locatorRepo.googleLoginButton).click();
			driver.findElement(locatorRepo.emailBox).sendKeys(locatorRepo.loginUserName);

			builder.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);

			driver.findElement(locatorRepo.passwordBox).sendKeys(locatorRepo.loginPassword);
			builder.sendKeys(Keys.ENTER).build().perform();
		}
		//Sometimes it is observed that the Google login needs another hit to go to the home page. For the safer side, this code is written
		if (driver.findElements(locatorRepo.newProjButtonBox).size() == 0) 
		{	
			driver.findElement(locatorRepo.googleLoginButton).click();
		}
	}

	@When("An existing user logs into the system")
	public void an_existing_user_logs_into_the_system() {
		System.out.println("---The user is logged in---");
	}

	@When("The user creates a new project")
	public void the_user_creates_a_new_project() throws InterruptedException {

		driver.switchTo().activeElement();

		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("iframe -----SIZE----------" + iframes.size());
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(locatorRepo.newProjButtonBox));
		// Thread.sleep(12000);
		driver.findElement(locatorRepo.newProjButtonBox).click();
		Thread.sleep(2000);
		iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("iframe ---------SIZE--------" + iframes.size());
		driver.findElement(By.xpath("//*[@name='project-name']")).sendKeys("Test Automation");

		driver.findElement(By.xpath("(//*[@name='description'])[2]")).sendKeys("Test Automation for Task World");

		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		builder.sendKeys(Keys.ENTER).build().perform();

	}

	@When("The user creates a new tasklist in the project")
	public void the_user_creates_a_new_tasklist_in_the_project() {
		wait.until(ExpectedConditions.elementToBeClickable(locatorRepo.taskListTitle));
		driver.findElement(locatorRepo.taskListTitle).sendKeys("Sample TaskList");
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER).build().perform();
	}

	@When("The user adds a new task to the tasklist")
	public void the_user_adds_a_new_task_to_the_tasklist() throws InterruptedException {
		driver.switchTo().defaultContent();
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ESCAPE).build().perform();
		driver.findElement(locatorRepo.addIconTask).click();
		Thread.sleep(2000);
		driver.findElement(locatorRepo.createTaskTitle).sendKeys("This is a task");
		driver.findElement(locatorRepo.createTaskCreateBtn).click();
	}

	@When("The user marks the task as completed")
	public void the_user_marks_the_task_as_completed() throws InterruptedException {
		driver.findElement(locatorRepo.taskHeaderMiniCheckbox).click();
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		// driver.findElement(By.xpath("//*[contains(@class,'header')][contains(@class,'task-header__ti')]")).click();
	}

	@Then("The user opens the completed task to see its details")
	public void the_user_opens_the_completed_task_to_see_its_details() {
		driver.findElement(locatorRepo.taskMiniHeaderLabel).click();
		driver.switchTo().activeElement();
		Assert.assertTrue(driver.findElement(locatorRepo.taskBigPropTab).isDisplayed());
	}

}