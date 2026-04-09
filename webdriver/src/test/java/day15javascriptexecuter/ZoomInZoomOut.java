package day15javascriptexecuter;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://amazon.com");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        Thread.sleep(2000);
        js.executeScript("document.body.style.zoom = '200%'");
        Thread.sleep(3000);
        js.executeScript("document.body.style.zoom = '50%'");
        Thread.sleep(1000);
        driver.quit();

    }
}
