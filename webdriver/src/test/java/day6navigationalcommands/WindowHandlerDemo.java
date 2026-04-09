package day6navigationalcommands;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String parentHandle = driver.getWindowHandle();


        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIds = driver.getWindowHandles();
        List<String> items = new ArrayList<>(windowIds);

        for (int i = 0; i < items.size(); i++){
            if(items.get(i).equals(parentHandle)){
                driver.switchTo().window(items.get(i + 1));
                System.out.println(driver.getTitle());
                driver.switchTo().window(parentHandle);
            }
        } 
        System.out.println(driver.getTitle());
        driver.quit();

/* 
        List<String> windowList = new ArrayList(windowIds);

        String parentId = windowList.get(0);
        String childId = windowList.get(1);
        

        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());

        driver.quit();
    
*/
    }
}
