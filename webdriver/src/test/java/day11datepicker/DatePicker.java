package day11datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

    static void futureDateSelector (WebDriver driver, String month, String date, String year) {

        while (true) {
            String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currMonth.equals(month) && currYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dt : dates) {
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }

    static void PastDateSelector (WebDriver driver, String month, String date, String year) {

        while (true) {
            String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currMonth.equals(month) && currYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dt : dates) {
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

       // futureDateSelector(driver, "April", "25", "2028");
      // PastDateSelector(driver, "May", "1", "1999");
       driver.quit();
    }

    //assingment is dummy ticket booking

}
