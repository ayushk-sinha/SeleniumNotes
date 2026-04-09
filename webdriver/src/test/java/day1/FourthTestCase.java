package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Test Case
-----------
1) Launch Browser (Chrome)
2) Open url https://demo.opencart.com/
3) Validate title should be "Your Store"
4) Close Browser
*/

public class FourthTestCase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        Thread.sleep(4000);
        String source = driver.getPageSource();
        String name = driver.getTitle();

        System.out.println(name);
        System.out.println(source);

        driver.quit();
    }
}
