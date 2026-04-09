package day12mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleTapAction {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick");

        driver.manage().window().maximize();
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame1);

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));

        Actions act = new Actions(driver);

        act.doubleClick(button).perform();

    }
}
