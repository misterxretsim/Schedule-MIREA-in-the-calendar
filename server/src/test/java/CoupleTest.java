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
     * Тестирование, если у нас одна пара в один день. Используется иное Timezone.
     */
    @Test
    public void startTestOneCoupleTimezone() {

        LocalDate start = LocalDate.of(2017, Month.DECEMBER, 31);
        LocalDate finish = LocalDate.of(2018, Month.JANUARY, 2);

        LocalTime time1 = LocalTime.of(0, 1, 0);
        LocalTime time2 = LocalTime.of(0, 3, 0); // Гыыы, пара длится 2 минуты

        DayOfWeek day = DayOfWeek.MONDAY;

        int timezone = 3 * 60 * 60; // GMT+3:00

        assertEquals(3 * 60 * 60, ZoneOffset.ofTotalSeconds(timezone).getTotalSeconds());

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
     * Тестирование, если у нас одна пара в расписании в течение 4 недель. Итого за 4 недели у нас 2 пары.
     */
    @Test
    public void startTestOneCoupleTwoDays() {

        LocalDate start = LocalDate.of(2018, Month.JANUARY, 1 /*+ 1*/); // Протестируем вторник.
        LocalDate finish = LocalDate.of(2018, Month.JANUARY, 1 + 7*4 + 1); // 29 + 1 = 30

        LocalTime time1 = LocalTime.of(9, 0, 0);
        LocalTime time2 = LocalTime.of(10, 30, 0);

        DayOfWeek day = DayOfWeek.TUESDAY;

        int timezone = 0; // GMT+0:00

        String nGr = "Группа-,";
        String nam = "Математика и н. значения .pgtju340)(HG(fvhgvh"; // http://xpoint.ru/forums/internet/standards/thread/29138.xhtml
        String typ = "Пр@ктика";
        String tic = "В.В. Иванов";
        String add = "Москва, проспект Вернадского 78, РТУ МИРЭА";
        String aud = "А-1";

        List<Couple> out = Couple.GetCouplesByPeriod(start, finish, time1, time2, timezone, day, true, nGr, nam, typ, tic, aud, add);

        /* Количество */            assertEquals(2, out.size());
        /* Время начала пары*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 2), LocalTime.of(9, 0, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(0).DateAndTimeOfCouple);
        /* Время начала пары*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 2 + 14), LocalTime.of(9, 0, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(1).DateAndTimeOfCouple);
        for(Couple o : out)
        {
            /* Продолжительность пары*/ assertEquals(Duration.between(time1, time2), o.DurationOfCouple);
            /* Название группы */       assertEquals(nGr, o.NameOfGroup);
            /* Название предмета */     assertEquals(nam, o.ItemTitle);
            /* Тип пары */              assertEquals(typ, o.TypeOfLesson);
            /* Имя преподавателя*/      assertEquals(tic, o.NameOfTeacher);
            /* Адрес кампуса */         assertEquals(add, o.Address);
            /* Аудитория */             assertEquals(aud, o.Audience);
        }
    }

    /**
     * Тестирование, если у нас одна пара в расписании в течение 4 месяцев. Итого за 4 месяца у нас полно пар раз в две недели.
     */
    @Test
    public void startTestOneCoupleDuring4Month() {

        LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate finish = LocalDate.of(2018, Month.APRIL, YearMonth.of(2018, Month.APRIL).lengthOfMonth()); // Последний день апреля 2018 года.

        LocalTime time1 = LocalTime.of(10, 40, 0);
        LocalTime time2 = LocalTime.of(12, 10, 0);

        DayOfWeek day = DayOfWeek.WEDNESDAY; // Среда

        int timezone = 0; // GMT+0:00

        String nGr = "АБВГ-01-ГА";
        String nam = ",vrihjegijrw\"woefkweo\21ew_093i2-FFOKEOKOкуцпцшокш342хгйе9з3кшйз3сь4мш9рХШАООХЕ3пп4хзр54.епз35щлр344щее.3уе4.н.3ен.ен.45..5н.54.542FPQWQ#@(-)@(#)$oqfk"; // http://xpoint.ru/forums/internet/standards/thread/29138.xhtml
        String typ = "Лабораторная работа.";
        String tic = "ГГГГгггггг. А. а.";
        String add = "ВОдичка";
        String aud = "А-(-1) = А+1";

        List<Couple> out = Couple.GetCouplesByPeriod(start, finish, time1, time2, timezone, day, true, nGr, nam, typ, tic, aud, add);

        /* Количество */            assertEquals(9, out.size());
        /* Время начала пары 1*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 3), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(0).DateAndTimeOfCouple);
        /* Время начала пары 2*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 17), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(1).DateAndTimeOfCouple);
        /* Время начала пары 3*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 31), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(2).DateAndTimeOfCouple);
        /* Время начала пары 4*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.FEBRUARY, 14), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(3).DateAndTimeOfCouple);
        /* Время начала пары 5*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.FEBRUARY, 28), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(4).DateAndTimeOfCouple);
        /* Время начала пары 6*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 14), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(5).DateAndTimeOfCouple);
        /* Время начала пары 7*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 28), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(6).DateAndTimeOfCouple);
        /* Время начала пары 8*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 11), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(7).DateAndTimeOfCouple);
        /* Время начала пары 9*/      assertEquals(OffsetDateTime.of(LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 25), LocalTime.of(10, 40, 0)), ZoneOffset.ofTotalSeconds(timezone)), out.get(8).DateAndTimeOfCouple);
        for(Couple o : out)
        {
            /* Продолжительность пары*/ assertEquals(Duration.between(time1, time2), o.DurationOfCouple);
            /* Название группы */       assertEquals(nGr, o.NameOfGroup);
            /* Название предмета */     assertEquals(nam, o.ItemTitle);
            /* Тип пары */              assertEquals(typ, o.TypeOfLesson);
            /* Имя преподавателя*/      assertEquals(tic, o.NameOfTeacher);
            /* Адрес кампуса */         assertEquals(add, o.Address);
            /* Аудитория */             assertEquals(aud, o.Audience);
        }
    }
}
