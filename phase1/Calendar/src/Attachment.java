package src;

import java.io.Serializable;

public abstract class Attachment implements Serializable {
    // An attachment for the events

    private String description;

    public String getDescription() {
        return this.description;
    }

}
