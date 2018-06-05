/*
Файл указывает правило, какие данные будут переданы клиенту.
 */

package ru.gosha.serverClient;

import java.io.*;

public class PackagePerClient implements Serializable {

    /*
    Тут содержатся файл .iCal
     */
    public final byte[] CalFile;

    /*
    Тут содержится количество созданных мероприятий.
     */
    public final int Count;

    /*
    Строит данные отправляемые на клиент.
     */
    public PackagePerClient(byte[] CalFile, int Count) {
        this.CalFile = CalFile;
        this.Count = Count;
    }
}
