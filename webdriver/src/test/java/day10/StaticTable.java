package day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.bind.annotation.AllArguments.Assignment;

public class StaticTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> tableCount = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println(tableCount.size());

        for (WebElement webElement : tableCount) {
            System.out.println(webElement.getText());
        }

        List<WebElement> header = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
        System.out.println(header.size());
        for (WebElement webElement : header) {
            System.out.println(webElement.getText());
        }
        WebElement name = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
        System.out.println(name.getText());

        System.out.println("---------------------------------------------------------");
        
        for (int r = 2; r < tableCount.size(); r++) {
            for (int c = 1; c < header.size(); c++) {
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(value+"\t"+"\t");
                
            }
            System.out.println();
            System.out.println("---------------------------------------------------------");
        }

        //Assignment go to https://blazedemo.com and book the lowest fare flight and validte the thank you messege
        driver.quit();
    }
}
