package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticatedPopups {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //normalLink
        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        //bypassLinkformation
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
