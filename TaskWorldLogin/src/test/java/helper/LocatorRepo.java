package helper;

import org.openqa.selenium.By;

/**
 * This Class contains the By element to be operated from the StepDefinition class
 * @author souvighosh
 *
 */
public class LocatorRepo {
	
	public By username = By.xpath("//*[@type='email']");
	public By password = By.xpath("//*[@type='password']");
	
	public By loginBtn = By.xpath("//*[@type='submit']");
	
	public By newProjButtonBox = By.xpath("//*[@id='react']//div[contains(@class,'tw-new-project-button-box')]");
	public By googleLoginButton = By.xpath("//*[@class='tw-google-login-button__text']/span");
	
	public By emailBox = By.xpath("//*[@type='email']");
	public By passwordBox = By.xpath("//*[@type='password']");
	public By taskListTitle = By.xpath("//*[@placeholder='Tasklist title']");
	public By addIconTask = By.xpath("//*[contains(@class,'icon-add')]");
	
	public By createTaskTitle = By.xpath("//*[contains(@placeholder,'Create')]");
	public By createTaskCreateBtn = By.xpath("//span[contains(text(),'Create')]");
	
	public By taskHeaderMiniCheckbox = By.xpath("//*[contains(@class,'tw-task-header__checkbox')]");
	public By taskMiniHeaderLabel = By.xpath("//*[contains(@class,'header')][contains(@class,'task-header__ti')]");
	
	public By taskBigPropTab = By.xpath("//*[contains(@class,'tw-property-tab-with-menu__tab-container')]");	
	
	public String loginUserName = "taskworldautomate@gmail.com";
	public String loginPassword = "Passw0rd@1";
	
}
