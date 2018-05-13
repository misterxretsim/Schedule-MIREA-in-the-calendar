package ru.gosha;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import ru.gosha.SG_Muwa.ExcelFileInterface;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;


import java.io.FileInputStream;
import java.io.IOException;

public class readFromExcelXLSX implements ExcelFileInterface{
    XSSFWorkbook myExcelBook = null;

    /**
     * Конструктор принимает название/путь к xls файлу и создает Workbook
     * @param fileName название/путь файла xls
     * @throws IOException
     */

    readFromExcelXLSX(String fileName) throws IOException {
        myExcelBook = new XSSFWorkbook(new FileInputStream(fileName));
    }

    /**
     * Функция возвращает значение ячейки.
     * @param Column Порядковый номер столбца. Отсчёт начинается с 1.
     * @param Row Порядковый номер строки. Отсчёт начинается с 1.
     * @return значение ячейки типа String.
     */

    @Override
    public String getCellData(int Column, int Row){
        String name = null;
        XSSFSheet myExcelSheet = myExcelBook.getSheet("1");
        XSSFRow row = myExcelSheet.getRow(Row - 1);

        if(row.getCell(Column - 1).getCellType() == XSSFCell.CELL_TYPE_STRING){
            name = row.getCell(Column - 1).getStringCellValue();
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * ЧОТО-ДЕЛОЕТ
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        myExcelBook.close();

    }
}
