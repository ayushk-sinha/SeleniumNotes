package day17;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().minimize();

        int brokenlinkcount = 0;
        int nonbrokencount = 0;

        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        for (WebElement linkElement : links) {

            String linkValue = linkElement.getAttribute("href");

            if(linkValue == null || linkValue.isEmpty()){
                System.out.println("Not able to read link");
                continue;
            }

            try{
                URL linkUrl = new URL(linkValue);

                HttpURLConnection conn = (HttpURLConnection)linkUrl.openConnection();
                conn.connect();

                if(conn.getResponseCode() >= 400){

                    System.out.println(linkValue + "====> brokenLink");
                    brokenlinkcount++;

            }   else {

                    System.out.println(linkValue+"====> notBroken");
                    nonbrokencount++;

            }
            } 
            catch(Exception e)

            {

            System.out.println("Found Some Exceptions");
            }
            
        }

        System.out.println("Total Links : " + nonbrokencount + brokenlinkcount);
        System.out.println("Total Non Broken Link : "+nonbrokencount);
        System.out.println("Total broken Links : "+brokenlinkcount);

        driver.quit();
    }
}
