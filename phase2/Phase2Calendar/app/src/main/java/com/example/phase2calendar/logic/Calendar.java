import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Calendar implements Serializable {

    private String name;
    private ArrayList<Event> eventsList;
    private ArrayList<Series> seriesList;
    private ArrayList<Memo> memosList;

    public Calendar(String name) {
        this.eventsList = new ArrayList<>();
        this.seriesList = new ArrayList<>();
        this.memosList = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addEvent(Event event){
        eventsList.add(event);
    }

    public void removeEvent(Event event){
        eventsList.remove(event);
    }

    public ArrayList<Event> getEvents(){
        return this.eventsList;
    }

    public void addTagToEvent(Event event, Tag tag){
        eventsList.get(eventsList.indexOf(event)).addAttachment(tag);
    }

    public void removeTagFromEvent(Event event, Tag tag){
        eventsList.get(eventsList.indexOf(event)).removeAttachment(tag);
    }

    public void addMemoToEvent(Event event, Memo memo){
        eventsList.get(eventsList.indexOf(event)).setMemo(memo);
    }

    public void removeMemoFromEvent(Event event){
        eventsList.get(eventsList.indexOf(event)).setMemo(null);
    }

    public void addSeries(Series series) {
        seriesList.add(series);
        for (Event e: series.getEvents()) {
            eventsList.add(e);
        }
    }

    public void removeSeries(Series series) {
        seriesList.remove(series);
    }

    public void addEventToSeries(Event event, Series series) {
        seriesList.get(seriesList.indexOf(series)).addEvent(event);
    }

    public ArrayList<Series> getSeries() { return this.seriesList; }

    public void addMemo(Memo memo) {
        memosList.add(memo);
    }

    public void removeMemo(Memo memo) {
        for(Event e:eventsList){
            if(e.getMemo().equals(memo)){
                this.removeMemoFromEvent(e);
            }
        }
        memosList.remove(memo);
    }

    public ArrayList<Memo> getMemos() {
        return memosList;
    }

    public void addAlertToEvent(Event event, Triple<String, String, LocalDateTime> t) {
        eventsList.get(eventsList.indexOf(event)).addAlert(t);
    }

    public void addAlertsToEvent(Event event, ArrayList<Triple<String, String, LocalDateTime>> t) {
        eventsList.get(eventsList.indexOf(event)).addAlerts(t);
    }

    public ArrayList<Alert> raiseAllAlerts(LocalDateTime now) {
        ArrayList<Alert> list = new ArrayList<Alert>();
        for (int i = 0; i < eventsList.size(); i++) {
            Event event = eventsList.get(i);
            list.addAll(event.raiseAlerts(now));
        }
        return list;
    }

}
