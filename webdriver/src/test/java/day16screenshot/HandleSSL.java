package day16screenshot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--no-sandbox");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());
        //driver.quit();
    }
}
