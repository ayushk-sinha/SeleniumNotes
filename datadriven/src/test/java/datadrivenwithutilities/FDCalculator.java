package datadrivenwithutilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        WebDriver driver = new ChromeDriver();
    
        String xlfile = "/home/kali/Documents/Code/DataDrivenTest/datadriven/testdata/calculate.xlsx";
        int  rowCount = ExcelUtils.getRowCount(xlfile, "Sheet1");
        System.out.println(rowCount);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

        driver.manage().window().maximize();
        
       
        for(int i = 1; i <= rowCount; i++) {

            String price  = ExcelUtils.getCellData(xlfile, "Sheet1", i, 0);
            String rateofInterest = ExcelUtils.getCellData(xlfile, "Sheet1", i, 1);
            String periodYear = ExcelUtils.getCellData(xlfile, "Sheet1", i, 2);
            String periodValue = ExcelUtils.getCellData(xlfile, "Sheet1", i, 3);
            String frequency = ExcelUtils.getCellData(xlfile, "Sheet1", i, 4);
            String expectedMaturityValue = ExcelUtils.getCellData(xlfile, "Sheet1", i, 5);

            
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
            
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofInterest);
           
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(periodYear);

            Select periodVal = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            periodVal.selectByContainsVisibleText(periodValue);
            
            Select frq = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            frq.selectByContainsVisibleText(frequency);
            
            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

            

            WebElement calculatedOutput = driver.findElement(By.xpath("//span[@id='resp_matval']//strong"));
            String val = calculatedOutput.getText();

            if (Double.parseDouble(val) == Double.parseDouble(expectedMaturityValue)) {

                System.out.println("Pssed...");
                ExcelUtils.setCellData(xlfile, "Sheet1", i, 7, "Pass");
                ExcelUtils.fillGreenColour(xlfile, "Sheet1", i, 7);

            }else {

                System.out.println("Failed..");
                ExcelUtils.setCellData(xlfile, "Sheet1", i, 7, "Fail");
                ExcelUtils.fillRedColour(xlfile, "Sheet1", i, 7);

            }
            
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
            Thread.sleep(1000);

        }

        driver.quit();

    }
}
