package MCompleteSeleniumFramework.TestsComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MCompleteSeleniumFramework.PageObjects.MLandingPage;

public class MBaseTest {

	public WebDriver driver;
	public MLandingPage mLandingPage;

	@Test
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\MCompleteSeleniumFramework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browser=	System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");
		

		if (browser.contains("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			
			if (browser.contains("headless"))
			{
				opt.addArguments("headless");
			}
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, Object>> getJsonDataMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, Object>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, Object>>>() {

				});// result={map,map1}

		return data;

	}

	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//note windows has \\ slahes for the path
		File file = new File(System.getProperty("user.dir") + "\\Mreports\\" + TestCaseName + ".png");
		FileUtils.copyFile(source, file);
		// return file- this will return the file object where the screenshot is being stored

		// following is the path where the screenshot will be going
		return System.getProperty("user.dir") + "\\Mreports\\" + TestCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public MLandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		mLandingPage = new MLandingPage(driver);
		mLandingPage.goTo();
		return mLandingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
