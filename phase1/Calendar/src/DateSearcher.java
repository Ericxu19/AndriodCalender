package src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DateSearcher implements EventSearcher<LocalDateTime> {
    //Searches through a list of events and returns those that have the specific date.
    @Override
    public ArrayList<Event> search(ArrayList<Event> events, LocalDateTime date) {
        ArrayList<Event> lst = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getStartTime() == date) {
                lst.add(event);
            }
        }
        return lst;

    }
}
