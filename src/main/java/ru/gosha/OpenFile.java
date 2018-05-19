package ru.gosha;

import ru.gosha.SG_Muwa.*;

import java.io.IOException;


public class OpenFile {

    /**
     * Функция определяет тип Excel файла(xls/xlsx)!!!!!ДОДЕЛАТЬ!!!!!!!
     * @param fileName название/путь файла.
     * @return возвращает значение ячейки Excel файла.
     * @throws IOException О ДА!
     */
    public String Open(String fileName, int Column, int Row) throws IOException {
        String type = null;
        String result = null;
        for (int i = 0; i < fileName.length(); i++){
            if (fileName.charAt(i) == '.'){
                type = fileName.substring(i + 1, fileName.length());
            }
        }

        if (type.equals("xlsx")) {
            ExcelFileInterface read1 = new  readFromExcelXLSX(fileName);
            result = read1.getCellData(Column,Row);
        }else {
            if (type.equals("xls")){
                ExcelFileInterface read = new readFromExcelXLS(fileName);
                result = read.getCellData(Column,Row);
            }
        }
        System.out.println(type);
        return result;
    }
}
