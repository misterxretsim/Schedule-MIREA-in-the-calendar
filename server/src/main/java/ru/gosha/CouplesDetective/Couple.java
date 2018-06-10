package ru.gosha.CouplesDetective;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalDateTime;


public class Couple {
    /**
     * Дата и время пары.
     */
    public LocalDateTime DateAndTimeOfCouple;
    /**
     * Название группы.
     */
    public String NameOfGroup;
    /**
     * Имя преподавателя.
     */
    public String NameOfTeacher;
    /**
     * Название пары.
     */
    public String ItemTitle;
    /**
     * Номер аудитории.
     */
    public String Audience;
    /**
     * Адрес корпуса.
     */
    public String Address;
    /**
     * Тип занятия (лекция, практика, лабораторная работа)
     */
    public String TypeOfLesson;

    /**
     * Получает на входе данные про две строки. Принимает решение, в какие дни будут пары.
     * @param start Дата и время начала сессии. Расписание будет составлено с этого дня и времени.
     * @param finish Дата и время окончания сессии. Расписание будет составлено до этого дня и времени.
     * @param timeStartOfCouple Время начала пары.
     * @param timeFinishOfCouple Время окончания пары.
     * @param nameOfGroup Рассматриваемая группа.
     * @param dayOfWeek Рассматриваемый день недели. Использование: Напрмер, Calendar.MUNDAY
     * @param ItemTitle Первая строка данных названия предмета. Сюда может входить и номера недель.
     * @param typeOfLesson Первая строка типа занятия.
     * @param nameOfTeacher Первая строка данных преподавателя.
     * @param audience Первая строка аудитории.
     * @param address Адрес корпуса.
     * @return Возвращает, в какие дни будут пары.
     */
    public static Iterable<Couple> GetCouplesByPeriod(LocalDate start, LocalDate finish, int timeStartOfCouple, int timeFinishOfCouple, DayOfWeek dayOfWeek, String nameOfGroup, String ItemTitle, String typeOfLesson, String nameOfTeacher, String audience, String address) {
        ///.get(Calendar.DAY_OF_WEEK);
        // TODO: Данная функция ещё не разработана.
        ItemTitle = ItemTitle.trim();
        if(ItemTitle.contains("н."))
        {
            if(ItemTitle.contains("кр."));
        }
        return null;
    }
}
