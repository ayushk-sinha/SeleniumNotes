package day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicPaginationWebTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo3x.opencartreports.com/admin/index.php?route=common/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.clear();
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();

        driver.findElement(By.xpath("//ul[@id='collapse5']//a[contains(text(),'Customers')]")).click();

       
        int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
        System.out.println(rows);
        for(int i = 1; i > rows; i++){
            String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[3]")).getText();
            System.out.println(customerName);
        }

        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();

        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        
        for(int page = 1; page < total_pages; page++){
            if(page > 1){
                WebElement activePaage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+page+"]"));
                activePaage.click();
            }
        
        }
        //assingment
        //go to testautomation blogspot read data from pagination and click all the checkboxes
        //go to orangeHRM and read username and roles from admin all those are bootsrtap table there will not be tr or th or td
        driver.quit();
    }
}
