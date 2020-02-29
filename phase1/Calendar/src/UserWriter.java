package src;

import java.util.Observable;
import java.util.Observer;
import java.io.*;

public class UserWriter implements Observer {
    @Override
    public void update(Observable o, Object arg){
        User user = (User) o;
        File file = new File("phase1/Calendar/Users/" + user.getUsername() + ".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }

        try {
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }


    }
}
