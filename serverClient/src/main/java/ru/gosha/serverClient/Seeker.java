/*
[SG]Muwa Михаил Павлович Сидоренко. 2018.
Файл представляет из себя хранилище запроса.
Суть запроса: имя искателя, тип искателя (преподаватель, студент), дата начала и конца семестра, адрес по-умолчанию.
 */

package ru.gosha.serverClient;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class Seeker {
    /**
     * Имя искателя.
     */
    public final String NameOfSeeker;
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
     * Часовой пояс, в котором указано время в расписании.
     */
    public final TimeZone timezone;
    /**
     * Адрес кампуса по-умолчанию.
     */
    public final String DefaultAddress;

    //public List<Couple> Couples = new LinkedList<>(); Нельзя здесь зависимость от Couple.

    /**
     * Создаёт экземпляр запроса.
     * @param nameOfSeeker Имя искателя. Это либо имя преподавателя, либо имя студента.
     * @param seekerType Тип искателя. Это либо преподаватель, либо студент.
     * @param dateStart Дата начала составления расписания. С какого календарного дня надо составлять расписание?
     * @param dateFinish Дата конца составления расписания. До какого календарного дня надо составлять расписание?
     * @param timezone Часовой пояс, в котором указано время в расписании.
     * @param defaultAddress Какой адрес корпуса по-умолчанию?
     */
    public Seeker(String nameOfSeeker, SeekerType seekerType, LocalDate dateStart, LocalDate dateFinish, TimeZone timezone, String defaultAddress) {
        NameOfSeeker = nameOfSeeker;
        this.seekerType = seekerType;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.timezone = timezone;
        DefaultAddress = defaultAddress;
    }
}
