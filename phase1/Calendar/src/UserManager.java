package src;

import java.io.File;
import java.io.IOException;

public class UserManager {

    UserManager(){}
    public User createUser(String username, String password) throws IOException {
        User tempUser = new User(username, password);
        createFile(username);
        return tempUser;
    }
    public void createFile(String username) throws IOException {
        File userFile = new File("phase1/Calendar/Users/UserInfo/"+username+".txt");
        userFile.createNewFile();
    }
    public void deleteUser(String username) throws IOException {
        File userFile = new File("phase1/Calendar/Users/UserInfo/"+username+".txt");
        userFile.delete();
    }
}
