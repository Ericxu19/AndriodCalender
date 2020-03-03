package src;

import java.util.Observable;
import java.util.Observer;
import java.io.*;

public class UserWriter implements Observer {
    @Override
    public void update(Observable o, Object arg){
        User user = (User) o;
        writeUser(user);
    }

    public void writeUser(User user){
        File file = new File("phase1/Calendar/Users/" + user.getUsername() + ".txt");

        try {
            file.createNewFile();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }
}
