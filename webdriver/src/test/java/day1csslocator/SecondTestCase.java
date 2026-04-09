package day1csslocator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

open amazon
find no of link
find no of images
print data
exit

*/
public class SecondTestCase {
    public static void main(String[] args) throws  InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        Thread.sleep(10000);


        List<WebElement> total_links = driver.findElements(By.tagName("a"));



        List<WebElement> images = driver.findElements(By.tagName("img"));


        for(WebElement a : total_links)
            System.out.println(a.getAttribute("href"));

        System.out.println("Total number of links present in the amazon website is:" + total_links.size());
        System.out.println("Total number of images present in the amazon website is:" + images.size());
        //System.out.println(images);
        driver.quit();
    }
}
