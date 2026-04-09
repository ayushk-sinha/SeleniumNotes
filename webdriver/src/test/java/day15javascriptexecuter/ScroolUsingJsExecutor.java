package day15javascriptexecuter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScroolUsingJsExecutor {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://leetcode.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //js.executeScript("window.scrollBy(0,1000)");
        
        //js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='Developer']"));
        js.executeScript("arguments[0].scrollIntoView()", ele);
        System.out.println(js.executeScript("return window.pageYOffset;"));
    }
}
