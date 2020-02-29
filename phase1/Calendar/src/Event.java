package src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.Serializable;

public class Event implements Serializable {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean past;
    private ArrayList<Attachment> attachments;
    private AlertHandler alertHandler;

    public Event(String name, String description, LocalDateTime startTime, LocalDateTime endTime){
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.past = false;
        this.attachments = new ArrayList<Attachment>();
        this.alertHandler = new AlertHandler();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void addAlert(Triple<String, String, LocalDateTime> t){
        alertHandler.addAlert(t);
    }

    public void addAlerts(ArrayList<Triple<String, String, LocalDateTime>> alert_info){
        alertHandler.addAlerts(alert_info);
    }

    public ArrayList<Alert> raiseAlerts(){
        return alertHandler.raiseAlerts();
    }
}
