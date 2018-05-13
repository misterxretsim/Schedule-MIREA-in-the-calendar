package ru.gosha;

import ru.gosha.SG_Muwa.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ExcelFileInterface read1 = new  readFromExcelXLSX("/Users/georgijfalileev/Downloads/Example2.xlsx");
        ExcelFileInterface read = new readFromExcelXLS("/Users/georgijfalileev/Downloads/Example1.xls");
        System.out.println(read.getCellData(1,1));
        System.out.println(read1.getCellData(2,2));
    }
}


