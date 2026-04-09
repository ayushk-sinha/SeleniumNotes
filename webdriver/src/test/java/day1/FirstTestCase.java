package day1;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Test Case
-----------
1) Launch Browser (Chrome)
2) Open url https://demo.opencart.com/
3) Validate title should be "Your Store"
4) Close Browser
*/
public class FirstTestCase {
    public static void main(String[] args){
        //1) Launch Browser (Chrome)

        //ChromeDriver driver = new ChromeDriver()

        WebDriver driver = new FirefoxDriver();

        //2) Open url https://demo.opencart.com/

        driver.get("https://www.youtube.com/");
        
        String act_title = driver.getTitle();


        //3) Validate title should be "Your Store"

        if(act_title.equals("YouTube")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        //4) Close Browser
        driver.close();
    }
}
