package src;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class DateSearcher {
    //Searches through a list of events and returns those that have the specific date.
    public List<Event> search(List<Event> events, LocalDateTime date)
    {
        List<Event> lst = new ArrayList<Event>();
        for (Event event: events)
        {
            if (event.getStartTime() == date)
            {
                lst.add(event);
            }
        }
        return lst;

    }
}
