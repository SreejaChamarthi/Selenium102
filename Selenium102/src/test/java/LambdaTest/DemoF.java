package LambdaTest;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebElement;
 
import org.testng.Assert;
 
import org.testng.annotations.Test;
 
public class DemoF extends BaseC {
 
    @Test
 
    public void test1() {
 
        // Step 1: Open LambdaTest Selenium Playground
 
        driver.get("https://www.lambdatest.com/selenium-playground");
 
        // Step 2: Click “Simple Form Demo”
 
        driver.findElement(By.linkText("Simple Form Demo")).click();
 
        // Step 3: Validate that the URL contains “simple-form-demo”
 
        String currentUrl = driver.getCurrentUrl();
 
        Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");
 
        // Step 4: Create a variable for a string value
 
        String message = "Welcome to LambdaTest";
 
        // Step 5: Enter value in “Enter Message” text box
 
        WebElement messageInput = driver.findElement(By.id("user-message"));
 
        messageInput.sendKeys(message);
 
        // Step 6: Click “Get Checked Value”
 
        driver.findElement(By.id("showInput")).click();
 
        // Step 7: Validate the displayed message
 
        WebElement displayedMessage = driver.findElement(By.id("message"));
 
        Assert.assertEquals(displayedMessage.getText(), message, "Displayed message does not match input");
 
    }
 
}
 
 
 