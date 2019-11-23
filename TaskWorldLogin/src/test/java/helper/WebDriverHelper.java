package helper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This helper Class is created to list down different operations associated to the test execution
 * @author souvighosh
 *
 */
public class WebDriverHelper {
	private static Properties properties;
	private static String DRIVER_PATH;
	private static String WEBPAGE_URL;

	/**
	 * This is to get the Driver path
	 * @return
	 */
	private static String getDriverPath() {
		Props.loadRunConfigProps("/Single/config.properties");
		DRIVER_PATH = Props.getProp("driver.root.dir");

		// System.out.println("DRIVER_PATH DRIVER_PATH DRIVER_PATH "+DRIVER_PATH);
		return DRIVER_PATH;
	}

	/**
	 * Set property of the driver
	 */
	public static void setDriverProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souvighosh\\Documents\\SleepCountry_Automation\\TaskWorldAutomate\\TaskWorldLogin\\src\\main\\java\\driver\\chromedriver.exe");
	}

	/**
	 * This is to initiate Driver
	 * @return
	 */
	public static WebDriver initiateDriver() {
		setDriverProperty();
		WebDriver driver = new ChromeDriver();
		LocalDriverManager.setWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * This is to open URL
	 * @param driver
	 */
	public static void openURL(WebDriver driver) {
		WEBPAGE_URL = "https://enterprise.taskworld.com/login";
		driver.get(WEBPAGE_URL);
	}

}