package src;

import java.io.File;
import java.io.IOException;

public class UserManager {

    UserManager(){}
    public User createUser(String username, String password) throws IOException {
        User tempUser = new User(username, password);
        createFile(tempUser);
        return tempUser;
    }
    public void createFile(User user) throws IOException {
        File userFile = new File("phase1/Calendar/Users/UserInfo/"+user.getUsername()+".txt");
        userFile.createNewFile();
    }
}
