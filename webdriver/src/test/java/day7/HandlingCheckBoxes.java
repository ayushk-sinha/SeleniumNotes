package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        //1) select specific checkbox
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();
        //2) Select all the checkboxes
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        for(int i = 0; i < 3; i++){
            boxes.get(i).click();
        }

        Thread.sleep(5000);
        
        for(int i = 0; i < boxes.size(); i++){
            if (boxes.get(i).isSelected()) {
                boxes.get(i).click();
            }
        }
               
    }
}
