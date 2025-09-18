	package LambdaTest;
 
	import org.openqa.selenium.remote.RemoteWebDriver;
 
	import org.openqa.selenium.chrome.ChromeOptions;
 
	import org.testng.annotations.BeforeClass;
 
	import org.testng.annotations.AfterClass;
 
	import org.testng.annotations.Parameters;
 
	import java.net.URL;
 
	import java.util.HashMap;
 
	public class BaseC {
 
	    protected RemoteWebDriver driver;
 
	    @SuppressWarnings("deprecation")
		@Parameters({"browser", "version", "platform"})
 
	    @BeforeClass
 
	    public void setUp(String browser, String version, String platform) throws Exception {
 
	        ChromeOptions browserOptions = new ChromeOptions();
 
	        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
 
	        ltOptions.put("username", "CHAMARTHISREEJA");
 
	        ltOptions.put("accessKey", "LT_8ssYz66MRcjlOx5XAaqCjnBHjpkdg7t86Q0rpDkOufZB28a");
	        ltOptions.put("visual", true);
 
	        ltOptions.put("video", true);
 
	        ltOptions.put("build", "LambdaTest");
 
	        ltOptions.put("project", "Selenium101");
 
	        ltOptions.put("name", this.getClass().getSimpleName());
 
	        ltOptions.put("platformName", platform);
 
	        ltOptions.put("browserName", browser);
 
	        ltOptions.put("browserVersion", version);
 
	        ltOptions.put("network", true);
 
	        ltOptions.put("console", true);
 
	        browserOptions.setCapability("LT:Options", ltOptions);
 
	        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
	    }
 
	    @AfterClass
 
	    public void tearDown() {
 
	        if (driver != null) {
 
	            driver.quit();
 
	        }
 
	    }
 
	}
 
 
 
 