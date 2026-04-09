package day16screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {
    public static void main(String[] args) throws  InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https:amazon.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        //TakesScreenshot ts = (TakesScreenshot)driver;

        //File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        
        //File targetFile = new File("/home/kali/Documents/Code/webdriver/webdriver/screenshots/fullpage.png");

        WebElement product = driver.findElement(By.xpath("//div[@role='presentation']//div[3]"));
        File sourcefile  = product.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("/home/kali/Documents/Code/webdriver/webdriver/screenshots/ProductCard.png");

        try {
            FileHandler.copy(sourcefile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
