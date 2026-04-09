package day13slider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderLocator {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();


        Actions act = new Actions(driver);


        WebElement slider1 = driver.findElement(By.xpath("//span[1]"));
        WebElement slider2 = driver.findElement(By.xpath("//span[2]"));

        System.out.println(slider1.getLocation());
        System.out.println(slider2.getLocation());

        act.dragAndDropBy(slider1, 100, 46).perform();;
        act.dragAndDropBy(slider2, -100, 47).perform();;



    }
}
