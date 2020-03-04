package src;

public class EventSearcherFactory {
    public EventSearcher getEventSearcher(String type){
        switch (type){
            case "AttachmentSearcher":
                return new AttachmentSearcher();
            case "DateSearcher":
                return new DateSearcher();
            case "EventNameSearcher":
                return new EventNameSearcher();
            default:
                return null;
        }
    }
}
