package day12mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        WebElement frame1 = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame1);

        WebElement element1 = driver.findElement(By.xpath("//li[1]"));
        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions act = new Actions(driver);

        act.dragAndDrop(element1, trash).perform();
    }
}
