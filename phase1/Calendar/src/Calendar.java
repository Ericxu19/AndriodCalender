package src;

import java.io.IOException;
import java.util.Scanner;

public class Calendar {

    private User currentUser = null;

    public void run() throws IOException {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(currentUser == null){
            System.out.println("Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            choice = Integer.parseInt(sc.nextLine());

            if(choice == 1){
                System.out.println("Enter your username:");
                String username = sc.next();
                if(currentUser == null){
                    System.out.println("The specified user does not exist.");
                } else {
                    System.out.println("Enter your password:");
                    String password = sc.nextLine();
                    LoginValidator val = new LoginValidator();
                    currentUser = val.validate(username, password);
                    if (currentUser == null) {
                        System.out.println("Your credentials are incorrect.");
                    }
                }
            }
            else if(choice == 2){
                System.out.println("Enter your desired username:");
                String username = sc.nextLine();
                if(username.contains(" ")){
                    System.out.println("Your username cannot contain spaces.");
                } else {
                    System.out.println("Enter your desired password:");
                    String password = sc.nextLine();
                    UserManager manager = new UserManager();
                    Object[] res = manager.createUser(username, password);
                    if((boolean) res[1] == false){
                        System.out.println("This username is already in use.");
                    } else {
                        currentUser = (User) res[0];
                        System.out.println("Account creation successful!");
                    }
                }
            } else {
                System.exit(0);
            }
        }
        while(true){
            //TODO program logic
        }
    }

}
