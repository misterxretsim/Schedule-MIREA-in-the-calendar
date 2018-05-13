package ru.gosha;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

interface ExcelFileInterface extends Closeable {
    String getCellData(int Column, int Row);
}

public class Main {



    public static void main(String[] args) throws IOException {
        ExcelFileInterface read = new readFromExcelXLS("/Users/georgijfalileev/Downloads/Example1.xls");
        System.out.println(read.getCellData(1,0));
    }

}

class readFromExcelXLS implements ExcelFileInterface{
    HSSFWorkbook myExcelBook = null;

    readFromExcelXLS(String fileName) throws IOException {
        myExcelBook = new HSSFWorkbook(new FileInputStream(fileName));
    }

    @Override
    public String getCellData(int Column, int Row){
        String name = null;
        HSSFSheet myExcelSheet = myExcelBook.getSheet("1");
        HSSFRow row = myExcelSheet.getRow(Row);

        if(row.getCell(Column).getCellType() == HSSFCell.CELL_TYPE_STRING){
            name = row.getCell(Column).getStringCellValue();
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public void close() throws IOException {
        myExcelBook.close();

    }
}


