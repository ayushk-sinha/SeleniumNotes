package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException{

        FileInputStream file = new FileInputStream("/home/kali/Documents/Code/DataDrivenTest/datadriven/testdata/Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        
        for(int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow curr = sheet.getRow(i);
            System.out.println();
            for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                System.out.print(curr.getCell(j).toString()+"   |   ");
            }
        }
        System.out.println();
        workbook.close();
        file.close();
    
    }
}
