package src;

import java.util.ArrayList;
import java.util.List;

public class MemoSearcher {
    //Searches a list of event and return those that are associated with the memo.
    public List<Event> search(List<Event> events, Memo memo ){
        List<Event> lst = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getMemo() == memo){
                lst.add(event);
            }
        }
        return lst;

    }
}
