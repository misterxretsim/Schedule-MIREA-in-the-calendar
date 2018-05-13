package ru.gosha;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ru.gosha.SG_Muwa.ExcelFileInterface;

import java.io.FileInputStream;
import java.io.IOException;

class readFromExcelXLS implements ExcelFileInterface {
    HSSFWorkbook myExcelBook = null;

    /**
     * Конструктор принимает название/путь к xls файлу и создает Workbook
     * @param fileName название/путь файла xls
     * @throws IOException
     */

    readFromExcelXLS(String fileName) throws IOException {
        myExcelBook = new HSSFWorkbook(new FileInputStream(fileName));
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
        HSSFSheet myExcelSheet = myExcelBook.getSheet("1");
        HSSFRow row = myExcelSheet.getRow(Row - 1);

        if(row.getCell(Column - 1).getCellType() == HSSFCell.CELL_TYPE_STRING){
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
