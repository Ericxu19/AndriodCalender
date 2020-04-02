package com.example.phase2calendar.logic;

import java.io.Serializable;
import java.util.jar.Attributes;

public abstract class Attachment implements Serializable, Nameable {
    // An attachment for the events

    private String description;

    public Attachment(String description){
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
