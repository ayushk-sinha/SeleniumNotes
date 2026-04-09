package day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.manage().window().maximize();


        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert normalAlert = driver.switchTo().alert();

        String text =normalAlert.getText();

        System.out.println(text);

        normalAlert.accept();


        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Alert confAlert1 = driver.switchTo().alert();

        confAlert1.accept();


        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Alert confAlert2 = driver.switchTo().alert();

        confAlert2.dismiss();

        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert inputAlert = driver.switchTo().alert();

        inputAlert.sendKeys("Welcome");

        inputAlert.accept();

        Thread.sleep(2000);

        driver.quit();
    }
}
