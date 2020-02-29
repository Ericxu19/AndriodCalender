import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AlertHandler alertHandler = new AlertHandler();

        alertHandler.addAlert(new Triple("use sink", "clean dishes", LocalDateTime.now()));

        ArrayList<Triple<String,String, LocalDateTime>> to_be_alerts = new ArrayList<Triple<String,String, LocalDateTime>>();
        to_be_alerts.add(new Triple<String,String, LocalDateTime>("tomorrow", "clean room", LocalDateTime.now().plusDays(1)));
        to_be_alerts.add(new Triple<String,String, LocalDateTime>("take a shower now", "clean body", LocalDateTime.now()));
        to_be_alerts.add(new Triple<String,String, LocalDateTime>("eat peanuts soon", "peanuts", LocalDateTime.now().plusMinutes(30)));

        alertHandler.addAlerts(to_be_alerts);

        File file = new File("phase1/Calendar/Users/alerts_testing.txt");
        file.createNewFile();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        objectOutputStream.writeObject(alertHandler);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

        AlertHandler alertHandler_read = (AlertHandler) objectInputStream.readObject();
        objectInputStream.close();

        Alert shower = alertHandler_read.getAlerts().get(2);
        System.out.println(shower.getDescription() + " " + shower.getName());
        System.out.println("past or not: " + shower.isPast());
        alertHandler_read.raiseAlerts();
        System.out.println("past or not: " + shower.isPast());
        System.out.println(alertHandler_read.getAlerts());
    }
}
