package com.example.phase2calendar.logic;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Alert implements Serializable, Nameable {

    private String description;
    private String name;
    private LocalDateTime time;

    public Alert(String description, String name, LocalDateTime time) {
        this.description = description;
        this.name = name;
        this.time = time;
    }

    public LocalDateTime getStartTime() {
        return time;
    }

    public LocalDateTime getEndTime(){ return null; }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

}