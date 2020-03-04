package src;

import java.util.ArrayList;

public class AttachmentSearcher implements EventSearcher<Attachment> {
    //Searches a list of event and return those that are associated with the memo.
    @Override
    public ArrayList<Event> search(ArrayList<Event> events, Attachment attachment) {
        ArrayList<Event> lst = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getAttachments().contains(attachment)) {
                lst.add(event);
            }
        }
        return lst;

    }
}
