package day16screenshot;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessTesting {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");

        Thread.sleep(6000);

        String title = driver.getTitle();
        System.out.println(title);

        if(title.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("TEST PASSED...");
        }else{
            System.out.println("TEST FAILED...");
        }
    }
}
