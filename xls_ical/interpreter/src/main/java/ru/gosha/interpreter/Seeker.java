/*
[SG]Muwa Михаил Павлович Сидоренко. 2018.
Файл представляет из себя хранилище запроса.
Суть запроса: имя искателя, тип искателя (преподаватель, студент), дата начала и конца семестра, адрес по-умолчанию.
 */

package ru.gosha.interpreter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TimeZone;

public class Seeker implements Serializable {
    /**
     * Имя искателя.
     */
    public final String nameOfSeeker;
    /**
     * Тип искателя. Преподаватель или студент группы?
     */
    public final SeekerType seekerType;
    /**
     * Начало семестра.
     */
    public final LocalDate dateStart;
    /**
     * Конец семестра.
     */
    public final LocalDate dateFinish;
    /**
     * Часовой пояс, где будут пары. Это значение в начале семестра.
     */
    public final TimeZone timezoneStart;
    /**
     * Часовой пояс, где будут пары. Это значение в конце семестра.
     */
    public final TimeZone timezoneFinish;
    /**
     * Указывать день, в котором меняется timeZone с timezoneStart на timezoneFinish
     */
    public final LocalDate switchTimeZone;
    /**
     * Адрес кампуса по-умолчанию.
     */
    public final String defaultAddress;


    //public List<Couple> Couples = new LinkedList<>(); Нельзя здесь зависимость от Couple.

    /**
     * Создаёт экземпляр запроса.
     * @param nameOfSeeker Имя искателя. Это либо имя преподавателя, либо имя студента.
     * @param seekerType Тип искателя. Это либо преподаватель, либо студент.
     * @param dateStart Дата начала составления расписания. С какого календарного дня надо составлять расписание? Дата указывается по местному времени.
     * @param dateFinish Дата конца составления расписания. До какого календарного дня надо составлять расписание? Дата указывается по местному времени.
     * @param timezoneStart Часовой пояс, где будут пары. Это значение в начале семестра.
     * @param timezoneFinish Часовой пояс, где будут пары. Это значение в конце семестра.
     * @param defaultAddress Какой адрес корпуса по-умолчанию?
     */
    public Seeker(String nameOfSeeker, SeekerType seekerType, LocalDate dateStart, LocalDate dateFinish, TimeZone timezoneStart, TimeZone timezoneFinish, LocalDate switchTimeZone, String defaultAddress) {
        this.nameOfSeeker = nameOfSeeker;
        this.seekerType = seekerType;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.timezoneStart = timezoneStart;
        this.timezoneFinish = timezoneFinish;
        this.switchTimeZone = switchTimeZone;
        this.defaultAddress = defaultAddress;
    }

    @Override
    public boolean equals(Object ex) {
        if (this == ex) {
            return true;
        }
        if(ex instanceof Seeker) {
            Seeker e = (Seeker) ex;
            return
                    nameOfSeeker.equals(e.nameOfSeeker) &&
                            seekerType.equals(e.seekerType) &&
                            dateStart.equals(e.dateStart) &&
                            dateFinish.equals(e.dateFinish) &&
                            timezoneStart == e.timezoneStart &&
                            defaultAddress.equals(e.defaultAddress);
        }
        return false;
    }
}
