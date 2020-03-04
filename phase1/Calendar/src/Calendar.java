package src;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Calendar {

    private User currentUser = null;
    private LocalDateTime currentTime;
    private boolean active = false;
    public void run() throws IOException {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (currentUser == null) {
            System.out.println("Select an option: \n 1. Login \n 2. Register \n 3. Exit");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.println("Enter your username:");
                String username = sc.nextLine().split(" ")[0];
                System.out.println("Enter your password:");
                String password = sc.nextLine();
                LoginValidator val = new LoginValidator();
                currentUser = val.validate(username, password);
                if (currentUser == null) {
                    System.out.println("The specified user does not exists, or your credentials are incorrect.");
                } else {
                    System.out.println("Login successful!");
                    active = true;
                }

            } else if (choice == 2) {
                System.out.println("Enter your desired username:");
                String username = sc.nextLine();
                if (username.contains(" ")) {
                    System.out.println("Your username cannot contain spaces.");
                } else {
                    System.out.println("Enter your desired password:");
                    String password = sc.nextLine();
                    UserManager manager = new UserManager();
                    Object[] res = manager.createUser(username, password);
                    if ((boolean) res[1] == false) {
                        System.out.println("This username is already in use.");
                    } else {
                        currentUser = (User) res[0];
                        System.out.println("Account creation successful!");
                    }
                }
            } else {
                sc.close();
                System.exit(0);
            }
        }
        System.out.println("Welcome, " + currentUser.getUsername() + "!");
        currentTime = LocalDateTime.now();
        UserWriter writer = new UserWriter();
        currentUser.addObserver(writer);
        while (active) {
            //TODO program logic
            System.out.println("Dashboard Options: \n 1. Exit");
            Scanner sc2 = new Scanner(System.in);
            if(sc2.next().equals("1")){
                System.exit(0);
            }

        }
    }

}
