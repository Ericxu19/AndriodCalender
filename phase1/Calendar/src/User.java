package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Observable;

public class User extends Observable implements Serializable {

    private String username;
    private String password;

    private ArrayList<Event> eventsList;
    private ArrayList<Series> seriesList;
    private ArrayList<Memo> memosList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.eventsList = new ArrayList<Event>();
        this.seriesList = new ArrayList<Series>();
        this.memosList = new ArrayList<Memo>();
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

    public void addEvent(Event event) {
        eventsList.add(event);
        signalChanges();
    }

    public void removeEvent(Event event) {
        eventsList.remove(event);
        signalChanges();
    }

    public void createEvent(String name, String description, LocalDateTime startTime, LocalDateTime endTime) {
        eventsList.add(new Event(name, description, startTime, endTime));
        signalChanges();
    }

    public ArrayList<Event> getEvents() {
        return eventsList;
    }

    public void addSeries(Series series) {
        seriesList.add(series);
        signalChanges();
    }

    public void removeSeries(Series series) {
        seriesList.remove(series);
        signalChanges();
    }

    public void addEventToSeries(Event event, Series series) {
        seriesList.get(seriesList.indexOf(series)).addEvent(event);
        signalChanges();
    }

    public ArrayList<Series> getSeries() {
        return seriesList;
    }

    public void addMemo(Memo memo) {
        memosList.add(memo);
        signalChanges();
    }

    public void removeMemo(Memo memo) {
        memosList.remove(memo);
        signalChanges();
    }

    public void createMemo(String description) {
        memosList.add(new Memo(description));
        signalChanges();
    }

    public ArrayList<Memo> getMemos() {
        return memosList;
    }

    public void addAlertToEvent(Event event, Triple<String, String, LocalDateTime> t) {
        eventsList.get(eventsList.indexOf(event)).addAlert(t);
        signalChanges();
    }

    public void addAlertsToEvent(Event event, ArrayList<Triple<String, String, LocalDateTime>> t) {
        eventsList.get(eventsList.indexOf(event)).addAlerts(t);
        signalChanges();
    }

    public ArrayList<Alert> raiseAllAlerts() {
        ArrayList<Alert> list = new ArrayList<Alert>();
        for (int i = 0; i < eventsList.size(); i++) {
            Event event = eventsList.get(i);
            list.addAll(event.raiseAlerts());
        }
        signalChanges();
        return list;
    }
}