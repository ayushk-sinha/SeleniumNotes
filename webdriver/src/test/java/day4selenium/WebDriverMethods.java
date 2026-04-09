package day4selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/");
        String name = driver.getTitle();
        System.out.println(name);
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        Thread.sleep(3000);
        boolean status = driver.findElement(By.linkText("OrangeHRM, Inc")).isDisplayed();
        System.out.println("Displayed?" + status);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> Windowids = driver.getWindowHandles();
        System.out.println(Windowids);
        System.out.println("Window ID:"+ driver.getWindowHandle());
        driver.quit();
    }
}

/*NOTES
-------------------------------------------------------------------------------------------
        1) Get Methods
        2) Conditional Methods
        4) Browser Methods
        5) Navigational Methods
        6) Wait Methods
-------------------------------------------------------------------------------------------
        Get Methods We can access these methods through WebDriver instance
-------------------------------------------------------------------------------------------
        get(url) - opens the url in the browser
        getTitle() - returns title of the page
        getCurrentUrl() - returns url of the page
        getPageSource() - return source code of the page
        getWindowHandle() - returns ID of the single browser windows
        getWindowHandles() - returns IDs of the multiple browser windows
-------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------
        Conditional Methods used to access these commands through WebElement
-------------------------------------------------------------------------------------------
        returns boolean value (true / flase)\
        isDisplayed() - we can check display status of the element
        isEnabled() - we can check enable/disable status of the element/operational element
        isSelected() - we can use to check the element is selected or not
-------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------
        Browser Methods
-------------------------------------------------------------------------------------------
        close() - close single browser
        quit() - close multiple browsers
-------------------------------------------------------------------------------------------        
*/
