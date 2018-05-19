import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import ru.gosha.OpenFile;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static junit.framework.Assert.*;

public class OpenFileTest {
    @Test
    public void testOpenXLS() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("1");

        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("АА");
        row.createCell(1).setCellValue("БА");

        // создаем подписи к столбцам (это будет вторая строчка в листе Excel файла)
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("АБ");
        row1.createCell(1).setCellValue("Груша");

        try (FileOutputStream out = new FileOutputStream(new File("delete1.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        OpenFile openFile = new OpenFile();
        assertEquals("Error 1:1(AA)", "АА", openFile.Open("delete1.xls", 1,1));
        assertEquals("Error 1:2(AБ)", "АБ", openFile.Open("delete1.xls", 1,2));
        assertEquals("Error 2:1(БА)", "БА", openFile.Open("delete1.xls", 2,1));
        assertEquals("Error 2:2(Груша)", "Груша", openFile.Open("delete1.xls", 2,2));
        //assertEquals("Error -1:-1(null)", null, openFile.Open("/Users/georgijfalileev/Downloads/delete.xls", -1,-1));
        //assertEquals("Error 999:999()", null, openFile.Open("/Users/georgijfalileev/Downloads/delete.xls",    100,100));

    }
}
