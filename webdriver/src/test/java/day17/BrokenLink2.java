package day17;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLink2 {
    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Thread.sleep(3000);

        driver.get("https://amazon.com/");
        driver.manage().window().minimize();
        

        int brokenLinkCount = 0;
        int nonBrokenLinkCount = 0;


        List<WebElement> links = driver.findElements(By.tagName("a"));


        for (WebElement linkElement : links) {
            String linkVal = linkElement.getAttribute("href");

            if(linkVal == null || linkVal.isEmpty()){
                System.out.println("Not possible to find link.....");
                continue;
            }
            try {

                URL linkUrl = new URL(linkVal);
                HttpURLConnection conn = (HttpsURLConnection)linkUrl.openConnection();
                //HttpURLConnection conn = (HttpURLConnection)linkUrl.openConnection();
                conn.connect();

                if(conn.getResponseCode() >= 400){

                    System.out.println("Link is broken : " + linkVal + "\nCode Obtained From getting connection : "+ conn.getResponseCode());
                    brokenLinkCount++;

                } else {

                    System.out.println("Link is worlinf : " + linkVal +  "\nCode Obtained From getting connection : "+ conn.getResponseCode());
                    nonBrokenLinkCount++;

                }

            }catch (Exception e){

                System.out.println("Some Exceptions");

            }
        }

        System.out.println("Total Number Of links : " + brokenLinkCount + nonBrokenLinkCount);
        System.out.println("Total Broken Link : " + brokenLinkCount);
        System.out.println("Total Non Broken Link : " + nonBrokenLinkCount);

        driver.quit();
    }
}

/*
//This Element is inside 3 nested shadow DOM.
String cssSelectorForHost1 = "#shadow-root";
String cssSelectorForHost2 = "#inner-shadow-dom";
String cssSelectorForHost3 = "#nested-shadow-dom";
Thread.sleep(1000);
SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
shadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));

//This Element is inside 2 nested shadow DOM.
String cssSelectorForHost1 = "#shadow-root";
String cssSelectorForHost2 = "#inner-shadow-dom";
Thread.sleep(1000);
SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
shadow1.findElement(By.cssSelector("#nested-shadow-element"));

//This Element is inside single shadow DOM.
String cssSelectorForHost1 = "#shadow-root";
Thread.sleep(1000);
SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
Thread.sleep(1000);
shadow.findElement(By.cssSelector("#shadow-element"));
 */