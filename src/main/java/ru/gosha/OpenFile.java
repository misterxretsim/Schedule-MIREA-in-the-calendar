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
    public String Open(String fileName) throws IOException {
        String type = null;
        String result = null;
        for (int i = 0; i < fileName.length(); i++){
            if (fileName.charAt(i) == '.'){
                type = fileName.substring(i + 1, fileName.length());
            }
        }

        if (type.equals("xlsx")) {
            ExcelFileInterface read1 = new  readFromExcelXLSX("/Users/georgijfalileev/Downloads/Example2.xlsx");
            result = read1.getCellData(1,1);
        }else {
            if (type.equals("xls")){
                ExcelFileInterface read = new readFromExcelXLS("/Users/georgijfalileev/Downloads/Example1.xls");
                result = read.getCellData(1,1);
            }
        }
        System.out.println(type);
        return result;
    }
}
