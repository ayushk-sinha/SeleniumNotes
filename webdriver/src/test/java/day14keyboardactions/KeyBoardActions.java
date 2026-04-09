package day14keyboardactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");

        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
        
        driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//span[@class='messageForUser']")).getText());
        driver.quit();
    }
}

