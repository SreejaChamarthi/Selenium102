package LambdaTest;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebElement;
 
import org.testng.Assert;
 
import org.testng.annotations.Test;
 
public class DragnDrop extends BaseC {
 
    @Test
 
    public void testSliderTo95() {
 
        // Step 1: Open LambdaTest Selenium Playground
 
        driver.get("https://www.lambdatest.com/selenium-playground");
 
        // Step 2: Click “Drag & Drop Sliders”
 
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
 
        // Step 3: Locate slider with default value 15
 
        WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
 
        WebElement rangeValue = driver.findElement(By.id("range"));
 
        // Drag slider to 95 using JavaScript (since drag-and-drop is tricky)
 
        String script = "arguments[0].value='95'; arguments[0].dispatchEvent(new Event('change'));";
 
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script, slider);
 
        // Validate the range value shows 95
 
        Assert.assertEquals(rangeValue.getText(), "95", "Slider value is not 95");
 
    }
 
}
 
 
 