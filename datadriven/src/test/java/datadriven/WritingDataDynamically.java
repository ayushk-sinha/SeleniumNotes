package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataDynamically {
    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream("/home/kali/Documents/Code/DataDrivenTest/datadriven/testdata/WriteDynamicData.xlsx");

        Scanner sc = new Scanner(System.in);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        System.out.print("Enter the no of rows : ");
        int numOfrow = sc.nextInt();

        System.out.print("Enter the no of cells : ");
        int numOfcell = sc.nextInt();

        for (int r = 0; r <= numOfrow; r++) { 
            XSSFRow currrow = sheet.createRow(r);
            System.out.println("Current row number : " + r);
            for (int c = 0; c < numOfcell; c++) {
                XSSFCell cell = currrow.createCell(c);
                System.out.print("Enter the value of cell number : " + c +" ");
                cell.setCellValue(sc.next());
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("FILE CREATED...");


    }
}
