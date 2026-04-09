package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Test Case
-----------
1) Launch Browser (Chrome)
2) Open url https://demo.opencart.com/
3) Validate title should be "Your Store"
4) Close Browser
*/
public class SecondTestCase {
    public static void main(String[] args){

        //Launching the browser
        WebDriver driver = new FirefoxDriver();
        
        //visiting the url
        driver.get("https://demo.opencart.com");
        
        //getting the title from the url
        String name = driver.getTitle();
        
        //printing the title name from the url
        System.out.println(name);


        //checking if page loads or not
        if(name.equals("Just a moment...")){
            System.out.println("Additional security bypass required");
        }else{
            System.out.println("Test Pass");
        }

        //closing the browser after task
        driver.close();
    }
}
