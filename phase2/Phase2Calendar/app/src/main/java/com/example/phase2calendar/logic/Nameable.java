package com.example.phase2calendar.logic;

import java.time.LocalDateTime;

public interface Nameable {
    public String getName();
    public String getDescription();
    public LocalDateTime getStartTime();
    public LocalDateTime getEndTime();
}
