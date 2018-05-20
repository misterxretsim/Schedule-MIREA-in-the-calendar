import jdk.jshell.spi.ExecutionControl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Couple {
    // Дата и время пары.
    public Date DateAndTimeOfCouple;
    // Имя преподавателя.
    public String NameOfTeacher;
    // Название пары.
    public String ItemTitle;
    // Номер аудитории.
    public String Audience;
    // Адрес корпуса.
    public String Address;
    // Тип занятия (лекция, практика, лабораторная работа)
    public String TypeOfLesson;

    /**
     * Получает на входе данные про две строки. Принимает решение, в какие дни будут пары.
     * @param Start Дата и время начала сессии. Расписание будет составлено с этого дня и времени.
     * @param Finish Дата и время окончания сессии. Расписание будет составлено до этого дня и времени.
     * @param TimeOfCouples Расписание звонков занятий в минутах.
     * @param DayOfTheWeek Рассматриваемый день недели.
     * @param ItemTitle Первая строка данных названия предмета. Сюда может входить и номера недель.
     * @param TypeOfLesson Первая строка типа занятия.
     * @param NameOfTeacher Первая строка данных преподавателя.
     * @param Audience Первая строка аудитории.
     * @param Address Адрес корпуса.
     * @param NumberOfCoupleDouble Какая это строка записи занятия? Первая строка пусть будет равна 0.
     * @return Возвращает, в какие дни будут пары.
     */
    public static Iterable<Couple> GetCouplesByPeriod(Date Start, Date Finish, int[] TimeOfCouples, byte DayOfTheWeek, String ItemTitle, String TypeOfLesson, String NameOfTeacher, String Audience, String Address, int NumberOfCoupleDouble) {
        ///.get(Calendar.DAY_OF_WEEK);
        // TODO: Данная функция ещё не разработана.
        return null;
    }
}
