import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Observable;

public class User extends Observable implements Serializable {

    private String username;
    private String password;
    private static final long serialVersionUID = 42L;

    private ArrayList<Calendar> calendarsList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.calendarsList = new ArrayList<>();
    }

    public void signalChanges() {
        setChanged();
        if (hasChanged()) notifyObservers();
        clearChanged();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addCalendar(Calendar calendar) {
        calendarsList.add(calendar);
    }

    public void addEventToCalendar(Event event, Calendar calendar) {
        calendar.addEvent(event);
        signalChanges();
    }

    public void removeEventFromCalendar(Event event, Calendar calendar) {
        calendar.removeEvent(event);
        signalChanges();
    }

    public void createEvent(String name, String description, LocalDateTime startTime, LocalDateTime endTime) {
        addEvent(new Event(name, description, startTime, endTime));
        signalChanges();
    }

    public ArrayList<Event> getEventsFromCalendar(Calendar calendar) {
        return calendar.getEvents();
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> returnList = new ArrayList<>();
        for(Calendar calendar:calendarsList){
            returnList.addAll(calendar.getEvents());
        }
        return returnList;
    }

    public void addTagToEventInCalendar(Event event, Tag att, Calendar calendar){
        calendar.addTagToEvent(event, att);
        signalChanges();
    }

    public void removeTagFromEventInCalendar(Event event, Tag att, Calendar calendar){
        calendar.removeTagFromEvent(event, att);
        signalChanges();
    }

    public void addMemoToEventInCalendar(Event event, Memo memo, Calendar calendar){
        calendar.addMemoToEvent(event, memo);
        signalChanges();
    }

    public void removeMemoFromEventInCalendar(Event event, Calendar calendar){
        calendar.removeMemoFromEvent(event);
        signalChanges();
    }

    public void addSeriesToCalendar(Series series, Calendar calendar) {
        calendar.addSeries(series);
        signalChanges();
    }

    public void removeSeriesFromCalendar(Series series, Calendar calendar) {
        calendar.removeSeries(series);
        signalChanges();
    }

    public void addEventToSeriesInCalendar(Event event, Series series, Calendar calendar) {
        calendar.addEventToSeries(event, series);
        signalChanges();
    }

    public ArrayList<Series> getSeriesFromCalendar(Calendar calendar) {
        return calendar.getSeries();
    }

    public void addMemoToCalendar(Memo memo, Calendar calendar) {
        calendar.addMemo(memo);
        signalChanges();
    }

    public void removeMemoFromCalendar(Memo memo, Calendar calendar) {
        calendar.removeMemo(memo);
        signalChanges();
    }

    public void createMemo(String name, String description) {
        addMemo(new Memo(name, description));
        signalChanges();
    }

    public ArrayList<Memo> getMemosFromCalendar(Calendar calendar) {
        return calendar.getMemos();
    }

    public ArrayList<Memo> getAllMemos() {
        for(Calendar c:calendarsList){
            c.getMemos();
        }
    }

    public void addAlertToEventInCalendar(Event event, Triple<String, String, LocalDateTime> t, Calendar calendar) {
        calendar.addAlertToEvent(event, t);
        signalChanges();
    }

    public void addAlertsToEventInCalendar(Event event, ArrayList<Triple<String, String, LocalDateTime>> t, Calendar calendar) {
        calendar.addAlertsToEvent(event, t);
        signalChanges();
    }

    public ArrayList<Alert> raiseAllAlerts(LocalDateTime now) {
        ArrayList<Alert> list = new ArrayList<Alert>();
        for(Calendar c:calendarsList){
            list.addAll(c.raiseAllAlerts(now));
        }
        return list;
    }
}