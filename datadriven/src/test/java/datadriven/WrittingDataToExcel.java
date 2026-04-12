package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDataToExcel {
    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream("/home/kali/Documents/Code/DataDrivenTest/datadriven/testdata/WriteData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("NOTEBOOKS");
        row0.createCell(1).setCellValue("DATE");
        row0.createCell(2).setCellValue("PRICE");
        row0.createCell(3).setCellValue("LOCATION");

        XSSFRow row1 = sheet.createRow(1) ;
        row1.createCell(0).setCellValue("Classmate");
        row1.createCell(1).setCellValue("27/05/2023");
        row1.createCell(2).setCellValue("350");
        row1.createCell(3).setCellValue("India");

        XSSFRow row2 = sheet.createRow(2) ;
        row2.createCell(0).setCellValue("Schoolbook");
        row2.createCell(1).setCellValue("20/04/2022");
        row2.createCell(2).setCellValue("125");
        row2.createCell(3).setCellValue("Bhutan");

        XSSFRow row3 = sheet.createRow(3) ;
        row3.createCell(0).setCellValue("Classmate");
        row3.createCell(1).setCellValue("12/06/2024");
        row3.createCell(2).setCellValue("760");
        row3.createCell(3).setCellValue("Nepal");

        XSSFRow row4 = sheet.createRow(4) ;
        row4.createCell(0).setCellValue("Ajanta");
        row4.createCell(1).setCellValue("30/09/2026");
        row4.createCell(2).setCellValue("1450");
        row4.createCell(3).setCellValue("Porkistan");

        XSSFRow row5 = sheet.createRow(5) ;
        row5.createCell(0).setCellValue("Coolshcool");
        row5.createCell(1).setCellValue("04/02/2026");
        row5.createCell(2).setCellValue("780");
        row5.createCell(3).setCellValue("Afghanistan");

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("FILE CREATED...");


    }
}
