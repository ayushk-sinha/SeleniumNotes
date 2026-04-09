package day4seleniumwebdriverwaitmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWaitMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mac Mini");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        List<WebElement> link_s  = driver.findElements(By.tagName("a"));
        System.out.println("no of links "+ link_s);
        for(WebElement a : link_s)
            System.out.println(a.getAttribute("href"));
        Thread.sleep(2000);

        driver.close();
        
    }
}

/*NOTES
-----------------------------------------------------------------
        Wait commands
        Why?
        To solve synchronization problem
-----------------------------------------------------------------
        Thread.Sleep() Java command Static wait time
        
        1) Implicit Wait
        2) Explicit wait/fluent wait

        Exceptions:
        NoSuchElementException - Element is not present in the page Synchronixation
        ElementNotFoundException - Locator is in-correct
------------------------------------------------------------------
        Advantage of Sleep():
        1) Easy to use
        
        DisAdv:
        1) If the time is not suffitient then you will get exception
        2) It will wait for maximum time out. This will reduce performance script.
        3) Multiple times
-------------------------------------------------------------------------------------------
        
        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Advantage:
        1) Single time / one statement
        2) It will not wait till maximum time if the ellement is available
        3) Applicable for all the elements
        4) easy to use

        Disadvantage:
        1) If the time not suffitient then you will get exceptions

        Explicit wait
        
*/
