package datadrivenwithutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    public static int getRowCount (String xlfile,String xlsheet) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        int rowCount = ws.getLastRowNum();

        wb.close();
        fi.close();

        return rowCount;

    }

    public static int getCellCount (String xlfile, String xlsheet, int rownum) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        int cellCount = row.getLastCellNum();

        wb.close();
        fi.close();

        return cellCount;

    }

    public static String getCellData (String xlfile, String xlsheet, int rownum, int column) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        String cellData;

        try {

            DataFormatter formatter = new DataFormatter();
            cellData = formatter.formatCellValue(cell);

        } catch (Exception e) {

            cellData = "";

        }

        wb.close();
        fi.close();

        return cellData;

    }

    public static void setCellData (String xlfile, String xlsheet, int rownum, int column, String data) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);
        cell.setCellValue(data);

        fo = new FileOutputStream(xlfile);

        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();

    }

    public static void fillGreenColour(String xlfile, String xlsheet, int rownum, int column) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rownum);
            if (row == null) {
                row = ws.createRow(rownum);
            }

        cell = row.getCell(column);
            if (cell == null) {
                cell = row.createCell(column);
            }

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fi.close(); // close input first

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        fo.close();
        wb.close();
        
        }

    public static void fillYellowColour (String xlfile, String xlsheet, int rownum, int column) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fo = new FileOutputStream(xlfile);

        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }

    public static void fillRedColour (String xlfile, String xlsheet, int rownum, int column) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fo = new FileOutputStream(xlfile);

        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }

}
