package day4seleniumwebdriverwaitmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement mytext = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        mytext.sendKeys("admin");

        WebElement mypass = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        mypass.sendKeys("admin123");

        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement Loginbutton = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Loginbutton.click();

    }
}

/*
Points When to use Explicit Wait

1) Conditional based, it will work more effectively.
2) Finding element is inclusive (for some conditions).
3) It will wait for the condition to be true, then consider the time.
4) We need to write multiple statements for the multiple elments.

*/