package src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean past;
    private ArrayList<Attachment> attachments;
    private AlertHandler alertHandler;

    public Event(String name, String description, LocalDateTime startTime, LocalDateTime endTime)
}
