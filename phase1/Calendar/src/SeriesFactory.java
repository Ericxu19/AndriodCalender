package src;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;

public class SeriesFactory {

    public Series createEmptySeries(String name, String description) {
        return new Series(name, description);
    }

    public Series createDayGapSeries(String name, String description, LocalDateTime startDateTime, LocalTime endTime, int dayGap, int numEvents) {
        return new Series(name, description, startDateTime, endTime, dayGap, numEvents);
    }

    public Series createSpecificDaySeries(String name, String description, LocalDateTime startDateTime, LocalTime endTime, HashSet<DayOfWeek> days, int numEvents) {
        return new Series(name, description, startDateTime, endTime, days, numEvents);
    }
}
