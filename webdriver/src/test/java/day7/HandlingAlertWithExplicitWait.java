package day7;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlertWithExplicitWait {
    public static void main(String[] args)  throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.manage().window().maximize();


        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert normalAlert = myWait.until(ExpectedConditions.alertIsPresent());

        String text =normalAlert.getText();

        System.out.println(text);

        normalAlert.accept();
    }
}
