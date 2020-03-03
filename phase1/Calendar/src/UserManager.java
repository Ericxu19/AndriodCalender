package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UserManager {

    UserManager(){}
    public User createUser(String username, String password) throws IOException {
        User user = new User(username, password);
        createUserFile(user);
        return user;
    }
    public boolean createUserFile(User user) throws IOException {
        File userFile = new File("Users/UserInfo/"+user.getUsername()+".txt");
        boolean success = userFile.createNewFile();
        if(success){
            UserWriter writer = new UserWriter();
            writer.writeUser(user);
        }
        return success;
    }
    public boolean deleteUser(String username) throws IOException {
        File userFile = new File("Users/UserInfo/"+username+".txt");
        return userFile.delete();
    }
}
