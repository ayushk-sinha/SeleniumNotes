package day9handledropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdownsSelectMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement selection = driver.findElement(By.xpath("//select[@id='country']"));
        Select sel = new Select(selection);
        //sel.selectByContainsVisibleText("India");
        //sel.selectByIndex(2);
        //sel.selectByValue("japan");
        List<WebElement> li = sel.getOptions();
        System.out.println(li.size());
        for(WebElement a:li){
            System.out.println(a.getText());
        }
    }
}
