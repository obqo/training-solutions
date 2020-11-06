package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance performance = new Performance(LocalDate.of(1989, 06, 02), "Queen", LocalTime.of(18, 0), LocalTime.of(20, 0));

        System.out.println("Artist name: " + performance.getArtist());
        System.out.println("Date of performance: " + performance.getDate());
        System.out.println("Start of performance: " + performance.getStartTime());
        System.out.println("End of performance: " + performance.getEndTime());

        System.out.println(performance.getInfo());

    }
}
