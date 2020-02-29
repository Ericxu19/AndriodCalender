package src;

import java.util.ArrayList;
import java.util.List;

public class AttachmentSearcher {
    //Searches a list of event and return those that are associated with the memo.
    public List<Event> search(List<Event> events, Attachment attachment ){
        List<Event> lst = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getAttachment().contains(attachment)){
                lst.add(event);
            }
        }
        return lst;

    }
}
