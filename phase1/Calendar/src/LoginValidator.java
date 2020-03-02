package src;

import java.io.*;

public class LoginValidator {
    public User validate(String username, String password){
        File userFile = new File("phase1/Calendar/Users/" + username + ".txt");
        User user = instantiateUser(userFile);
        if(user.getPassword() == password){
            return user;
        }
        return null;
    }

    private User instantiateUser(File userFile) {
        User user = null;
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(userFile);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            user = (User) in.readObject();

            in.close();
            file.close();
        } catch (FileNotFoundException e){
            //TODO
        } catch (IOException e){
            //TODO
        } catch (ClassNotFoundException e){
            //TODO
        }
        return user;
    }
}
