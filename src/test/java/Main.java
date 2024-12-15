import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSimpleForm() {
    	driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        // Fill out the form
        driver.findElement(By.name("my-text")).sendKeys("Test Input");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        // Verify submission
        String result = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(result, "Received!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}