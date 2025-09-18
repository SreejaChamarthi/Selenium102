package LambdaTest;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.JavascriptExecutor;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
 
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.openqa.selenium.support.ui.Select;
 
import org.testng.Assert;
 
import org.testng.annotations.Test;
 
import java.time.Duration;
 
public class InputF extends BaseC {
 
    @Test
 
    public void testFormSubmission() {
 
        // Step 1: Open LambdaTest Selenium Playground
 
        driver.get("https://www.lambdatest.com/selenium-playground");
 
        // Step 2: Click “Input Form Submit”
 
        driver.findElement(By.linkText("Input Form Submit")).click();
 
        // Step 3: Click Submit without filling anything
 
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
 
        // Step 4: Assert error message (browser-level validation)
 
        WebElement nameField = driver.findElement(By.name("name"));
 
        String validationMessage = nameField.getAttribute("validationMessage");
 
        Assert.assertTrue(validationMessage.contains("fill out this field"),
 
                "Expected browser validation message not found. Actual: " + validationMessage);
 
        // Step 5: Fill in all fields
 
        driver.findElement(By.name("name")).sendKeys("Jeswanth");
 
        driver.findElement(By.cssSelector("#inputEmail4")).sendKeys("jeswanth@gmail.com");
 
        driver.findElement(By.name("password")).sendKeys("Password123");
 
        driver.findElement(By.name("company")).sendKeys("Capgemini");
 
        driver.findElement(By.name("website")).sendKeys("https://capgemini.com");
 
        driver.findElement(By.name("city")).sendKeys("Bangalore");
 
        driver.findElement(By.name("address_line1")).sendKeys("123 Street");
 
        driver.findElement(By.name("address_line2")).sendKeys("Near Tech Park");
 
        driver.findElement(By.cssSelector("#inputState")).sendKeys("Karnataka");
 
        driver.findElement(By.name("zip")).sendKeys("560001");
 
        // Step 6: Select “United States” from Country dropdown using Select class
 
        WebElement countryDropdown = driver.findElement(By.name("country"));
 
        Select countrySelect = new Select(countryDropdown);
 
        countrySelect.selectByVisibleText("United States");
 
        // Step 7: Scroll to and click Submit button safely using JS click fallback
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
 
        // Ensure visibility and enabled state
 
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not visible.");
 
        Assert.assertTrue(submitButton.isEnabled(), "Submit button is not enabled.");
 
        // Scroll into view and click using JS to avoid click interception
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
 
        // Step 8: Validate success message
 
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
 
        Assert.assertTrue(successMsg.getText().contains("Thanks for contacting us"),
 
                "Success message not found. Actual: " + successMsg.getText());
 
    }
 
}
 
 
 