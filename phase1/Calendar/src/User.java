package src;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;

public class User implements Serializable {

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

    public ArrayList<Event> getEvents() {
        return eventsList;
    }

    public void addSeries(Series series) {
        seriesList.add(series);
    }

    public void removeSeries(Series series) {
        seriesList.remove(series);
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

    public ArrayList<Memo> getMemos() {
        return memosList;
    }
}