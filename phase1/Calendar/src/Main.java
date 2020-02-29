package src;


import src.Alert;
import src.AlertHandler;



import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AlertHandler alertHandler = new AlertHandler();

        alertHandler.addAlert(new Triple<>("use sink", "clean dishes", LocalDateTime.now()));

        ArrayList<Triple<String,String, LocalDateTime>> to_be_alerts = new ArrayList<>();
        to_be_alerts.add(new Triple<>("tomorrow", "clean room", LocalDateTime.now().plusDays(1)));
        to_be_alerts.add(new Triple<>("take a shower now", "clean body", LocalDateTime.now()));
        to_be_alerts.add(new Triple<>("eat peanuts soon", "peanuts", LocalDateTime.now().plusMinutes(30)));

        alertHandler.addAlerts(to_be_alerts);

        // use this if working directory is at group_0259
        File file = new File("Users/alerts_testing.txt");

        // use this if working directory is at Calendar
        //File file = new File("Users/alerts_testing.txt");

        //does stuff iff there is no existing file
        file.createNewFile();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        objectOutputStream.writeObject(alertHandler);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

        AlertHandler alertHandler_read = (AlertHandler) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(alertHandler_read.getAlerts());
        alertHandler_read.raiseAlerts();
        System.out.println(alertHandler_read.getAlerts());

        //Tev User Tests
        UserManager userC = new UserManager();
        userC.createUser("tev", "123");
        userC.createUser("tev2", "1234");
        userC.createUser("tev3", "12345");

        //userC.deleteUser("tev");
    }
}
