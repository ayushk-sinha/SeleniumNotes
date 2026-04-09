package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Test Case
-----------
First step
1) Launch Browser 
2) Visti url https://facebook.com/
3) Print the title of the web page 
4) close the browser

Second step
1) Launch Browser 
2) Visti url https://facebook.com/
3) Store the title in a variable
4) Check id the variable is Valid or not 
4) close the browser
 */
public class ThirdTestCase {
    public static void main(String[] args){
        //Launch the browser
        WebDriver driver = new FirefoxDriver();

        //visit url
        driver.get("https://youtube.com");

        //store title in variable
        String name  = driver.getTitle();

        //print the title
        System.out.println(name);

        if(name.equals("Facebook")){
            System.out.println("200 ok");
        }else{
            System.out.println("FAAAAAAA");
        }

        //close browser
        driver.quit();

    }

}
