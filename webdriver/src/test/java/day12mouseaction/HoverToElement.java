package day12mouseaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverToElement {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();

        WebElement button = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        WebElement support = driver.findElement(By.xpath("//ul[@class='p9yS7v M8Sosa _1psv1ze3c _1psv1ze5l _1psv1ze7c _1psv1ze9l _1cisqlf2']//div[@class='pkKEsC'][normalize-space()='24x7 Customer Care']"));

        Actions act = new Actions(driver);
        act.moveToElement(button).moveToElement(support).click().perform();
        driver.quit();
    }
}
