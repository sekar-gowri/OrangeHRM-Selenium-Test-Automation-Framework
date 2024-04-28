package orangehrm_base_class;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import orangehrm_utilities.Read_Configuration;

public class Base_Class {

	public static WebDriver driver;
	static Read_Configuration rc = new Read_Configuration();

	@Parameters("Browser")
	@BeforeTest
	public void setUp(String Browser) {

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.get(rc.get_Application_URL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public static void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}
}
