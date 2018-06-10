import org.junit.Test;
import static org.junit.Assert.*;
import ru.gosha.CouplesDetective.Couple;

import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;

public class CoupleTest {

    @Test
    public void startTestCouple() {

        LocalDate start = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate finish = LocalDate.of(2000, Month.JANUARY, 1 + 14 + 14);

        int time1 = 1;
        int time2 = 3; // Гыыы, пара длится 2 минуты

        DayOfWeek day = DayOfWeek.MONDAY;

        String nGr = "Группа-01 32";
        String nam = "Математика и инженерия."; // http://xpoint.ru/forums/internet/standards/thread/29138.xhtml

        Couple.GetCouplesByPeriod(start, finish, time1, time2, day, nGr, );
    }
}
