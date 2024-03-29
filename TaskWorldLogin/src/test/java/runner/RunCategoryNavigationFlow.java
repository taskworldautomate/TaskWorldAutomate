package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.TestNGCucumberRunner;
import helper.LocalDriverManager;

@RunWith(Cucumber.class)

@CucumberOptions(

	features = { "features" }, glue = { "stepdefinitions" },

	tags = { "@validateLoginAndTaskCreation" })
	public class RunCategoryNavigationFlow {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeTest(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@AfterMethod(alwaysRun = true)
	public void endTestExecution() {
		LocalDriverManager.getDriver().quit();

	}

}
