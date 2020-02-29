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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addEvent(Event event) {
        eventsList.add(event);
    }

    public void removeEvent(Event event) {
        eventsList.remove(event);
    }

    public void createEvent(String name, String description, LocalDateTime startTime, LocalDateTime endTime){
        eventsList.add(new Event(name, description, startTime, endTime));
    }

    public ArrayList<Event> getEvents() {
        return eventsList;
    }

    public void addSeries(Series series) {
        seriesList.add(series);
    }

    public void removeSeries(Series series) {
        seriesList.remove(series);
    }

    public void addEventToSeries(Event event, Series series){
        seriesList.get(seriesList.indexOf(series)).addEvent(event);
    }

    public ArrayList<Series> getSeries() {
        return seriesList;
    }

    public void addMemo(Memo memo) {
        memosList.add(memo);
    }

    public void removeMemo(Memo memo) {
        memosList.remove(memo);
    }

    public void createMemo(String description) { memosList.add(new Memo(description)); }

    public ArrayList<Memo> getMemos() {
        return memosList;
    }

    public void addAlertToEvent(Event event, Triple<String, String, LocalDateTime> t){
        eventsList.get(eventsList.indexOf(event)).addAlert(t);
    }

    public void addAlertsToEvent(Event event, ArrayList<Triple<String, String, LocalDateTime>> t){
        eventsList.get(eventsList.indexOf(event)).addAlerts(t);
    }

    public ArrayList<Alert> raiseAllAlerts(){
        ArrayList<Alert> list = new ArrayList<Alert>();
        for(int i = 0; i < eventsList.size(); i++){
            Event event = eventsList.get(i);
            list.addAll(event.raiseAlerts());
        }
        return list;
    }
}