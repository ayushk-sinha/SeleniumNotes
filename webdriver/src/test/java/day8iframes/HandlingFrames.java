package day8iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

        driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));

        driver.switchTo().frame(frame2);

        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

        driver.switchTo().defaultContent();

        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));

        driver.switchTo().frame(frame3);

        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("FrameInsideFrame");

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        
        driver.switchTo().frame(iframe1);

        driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();

        driver.switchTo().defaultContent();

        // WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));

        // driver.switchTo().frame(frame5);

        // driver.findElement(By.xpath("//a[@href='https://a9t9.com']")).click();
        // Thread.sleep(3000);

        // //WebElement finalframe = driver.findElement(By.xpath("//html[@class=' js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage no-websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers no-applicationcache svg inlinesvg smil svgclippaths']"));
        // driver.switchTo().frame(2);

        // boolean imgcheck = driver.findElement(By.xpath("img[alt='Ui.Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
        // System.out.println(imgcheck);

        // driver.switchTo().defaultContent();

        driver.quit();

    }
}
