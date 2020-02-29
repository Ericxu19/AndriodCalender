package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UserManager {

    UserManager(){}
    public User createUser(String username, String password) throws IOException {
        User tempUser = new User(username, password);
        createFile(username, password);
        return tempUser;
    }
    public boolean createFile(String username, String password) throws IOException {
        File userFile = new File("phase1/Calendar/Users/UserInfo/"+username+".txt");
        boolean success = userFile.createNewFile();
        if(success){
            OutputStream os = new FileOutputStream(userFile);
            byte[] pwBytes = password.getBytes();
            os.write(pwBytes);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteUser(String username) throws IOException {
        File userFile = new File("phase1/Calendar/Users/UserInfo/"+username+".txt");
        return userFile.delete();
    }
}
