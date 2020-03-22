package com.example.phase2calendar.logic;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {

    private String text;
    private Event event;
    private User sender;
    private User recipient;
    private LocalDateTime timeSent;

    public Message(String text, User sender, User recipient, LocalDateTime timeSent){
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = timeSent;
    }

    public Message(String text, Event event, User sender, User recipient, LocalDateTime timeSent){
        this.text = text;
        this.event = event;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = timeSent;
    }
}
