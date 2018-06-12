import org.junit.Test;
import static org.junit.Assert.*;
import ru.gosha.CouplesDetective.Couple;

import java.time.*;
import java.util.List;

public class CoupleTest {

    /**
     * Тестирование, если у нас одна пара в один день.
     */
    @Test
    public void startTestOneCouple() {

        LocalDate start = LocalDate.of(2017, Month.DECEMBER, 31);
        LocalDate finish = LocalDate.of(2018, Month.JANUARY, 2);

        LocalTime time1 = LocalTime.of(0, 1, 0);
        LocalTime time2 = LocalTime.of(0, 3, 0); // Гыыы, пара длится 2 минуты

        DayOfWeek day = DayOfWeek.MONDAY;

        int timezone = 0; // GMT+0:00

        String nGr = "Группа-01 32";
        String nam = "Математика и инженерия."; // http://xpoint.ru/forums/internet/standards/thread/29138.xhtml
        String typ = "Лк";
        String tic = "Иванов В.В.";
        String add = "Москва, проспект Вернадского 78, РТУ МИРЭА";
        String aud = "А-1";

        List<Couple> out = Couple.GetCouplesByPeriod(start, finish, time1, time2, timezone, day, true, nGr, nam, typ, tic, aud, add);

        /* Количество */            assertEquals(1, out.size());
        /* Время начала пары*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 1), LocalTime.of(0, 1, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(0).DateAndTimeOfCouple);
        /* Продолжительность пары*/ assertEquals(Duration.between(time1, time2), out.get(0).DurationOfCouple);
        /* Название группы */       assertEquals(nGr, out.get(0).NameOfGroup);
        /* Название предмета */     assertEquals(nam, out.get(0).ItemTitle);
        /* Тип пары */              assertEquals(typ, out.get(0).TypeOfLesson);
        /* Имя преподавателя*/      assertEquals(tic, out.get(0).NameOfTeacher);
        /* Адрес кампуса */         assertEquals(add, out.get(0).Address);
        /* Аудитория */             assertEquals(aud, out.get(0).Audience);
    }

    /**
     * Тестирование, если у нас одна пара на один конкретный день дней.
     */
    @Test
    public void startTestOneHardCouple() {

        LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate finish = LocalDate.of(2018, Month.JANUARY, 1);

        LocalTime time1 = LocalTime.of(0, 1, 0);
        LocalTime time2 = LocalTime.of(0, 3, 0); // Гыыы, пара длится 2 минуты

        DayOfWeek day = DayOfWeek.MONDAY;

        int timezone = 0; // GMT+0:00

        String nGr = "Группа-24 32";
        String nam = "Русский jaja номер Нан 1 4 2."; // http://xpoint.ru/forums/internet/standards/thread/29138.xhtml
        String typ = "Лаб.";
        String tic = "Момов А.А.";
        String add = "Україна, Київ, Центральна 8";
        String aud = "202";

        List<Couple> out = Couple.GetCouplesByPeriod(start, finish, time1, time2, timezone, day, true, nGr, nam, typ, tic, aud, add);

        /* Количество */            assertEquals(1, out.size());
        /* Время начала пары*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 1), LocalTime.of(0, 1, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(0).DateAndTimeOfCouple);
        /* Продолжительность пары*/ assertEquals(Duration.between(time1, time2), out.get(0).DurationOfCouple);
        /* Название группы */       assertEquals(nGr, out.get(0).NameOfGroup);
        /* Название предмета */     assertEquals(nam, out.get(0).ItemTitle);
        /* Тип пары */              assertEquals(typ, out.get(0).TypeOfLesson);
        /* Имя преподавателя*/      assertEquals(tic, out.get(0).NameOfTeacher);
        /* Адрес кампуса */         assertEquals(add, out.get(0).Address);
        /* Аудитория */             assertEquals(aud, out.get(0).Audience);
    }

    /**
     * Тестирование, если у нас одна пара в несколько дней.
     */
    @Test
    public void startTestOneCoupleTwoDays() {

        LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate finish = LocalDate.of(2018, Month.JANUARY, 1 + 14);

        LocalTime time1 = LocalTime.of(9, 0, 0);
        LocalTime time2 = LocalTime.of(10, 30, 0); // Гыыы, пара длится 2 минуты

        DayOfWeek day = DayOfWeek.MONDAY;

        int timezone = 0; // GMT+0:00

        String nGr = "Группа-,";
    }
}
