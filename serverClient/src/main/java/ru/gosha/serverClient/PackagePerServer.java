/*
Файл указывает правило, какие данные будут переданы серверу.
 */

package ru.gosha.serverClient;

import java.io.*;

public class PackagePerServer implements Serializable {

    /**
    Тут содержатся файлы и .xls и .xlsx
    Это массив файлов. Каждый файл - это массив байтов.
     */
    public final byte[][] ExcelsFiles;
    /**
    Тут содержатся критерии запроса.
     */
    public final Seeker QueryCriteria;

    /**
    Строит данные отправляемые на сервер.
     @param ExcelsFiles Тут содержатся файлы и .xls и .xlsx. Это массив файлов. Каждый файл - это массив байтов.
     @param QueryCriteria Тут содержатся критерии запроса.
     */
    public PackagePerServer(byte[][] ExcelsFiles, Seeker QueryCriteria) {
        this.ExcelsFiles = ExcelsFiles;
        this.QueryCriteria = QueryCriteria;
    }
}
