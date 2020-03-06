package src;

public class Memo extends Attachment {
    //src.Memo class that stores a memo for a event
    private String name;
    private String description;

    public Memo (String name, String info){
        this.name = name;
        this.description = info;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

}
