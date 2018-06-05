/*
Файл указывает правило, какие данные будут переданы клиенту.
 */

package ru.gosha.serverClient;

import java.io.*;

public class PackageToClient implements Serializable {

    /**
     * Тут содержатся файл .iCal.
     */
    public final byte[] CalFile;

    /**
     * Тут содержится количество созданных мероприятий.
     */
    public final int Count;

    /**
     * Тут содержится сообщение от сервера. Например: "Найдено несколько преподавателей с этим именем: Иванов И.И. и Иванов И.А."
     */
    public final String Messages;

    /**
    Строит данные отправляемые на клиент.
     @param CalFile Тут содержатся файл .iCal.
     @param Count Тут содержится количество созданных мероприятий.
     */
    public PackageToClient(byte[] CalFile, int Count, String Messages) {
        this.CalFile = CalFile;
        this.Count = Count;
        this.Messages = Messages;
    }
}
