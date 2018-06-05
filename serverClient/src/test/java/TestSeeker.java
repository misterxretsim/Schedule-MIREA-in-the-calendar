
import ru.gosha.serverClient.*;

import java.time.LocalDate;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSeeker {

    @Test
    public void startTestSeeker() {

        System.out.println("Test Seeker start.");

        Seeker test = new Seeker("name", SeekerType.Teacher, LocalDate.of(2000, 5, 5), LocalDate.of(2000, 5, 10), +3 * 60 * 60, "Москва, проспект Вернадского, 78, РТУ МИРЭА");

        assertEquals("name", test.NameOfSeeker);
        assertEquals(SeekerType.Teacher, test.seekerType);
        assertEquals(LocalDate.of(2000, 5, 5), test.dateStart);
        assertEquals(LocalDate.of(2000, 5, 10), test.dateFinish);
        assertEquals(10800, test.timezone);
        assertEquals("Москва, проспект Вернадского, 78, РТУ МИРЭА", test.DefaultAddress);
    }


}