import java.util.*;
import controller.Controller;
import model.BankAccount;
import model.LoginModel;
import display.*;
import util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Welcome To Bank System ====");
            
            System.out.print("Press (Y/y) to start: ");
            char press = input.next().charAt(0);
            input.nextLine();

            if (press == 'Y' || press == 'y') {
                // User login
                System.out.print("Pin Code: ");
                String pin = input.nextLine();
                BankAccount loggedInUser = controller.loginUser(pin);

                if (loggedInUser != null) {
                    // User authenticated
                    handleUserMenu(loggedInUser);
                } else {
                    System.out.println("Invalid Pin! Please try again.\n");
                }

            } else if (press == '1') {
                System.out.print("Username: ");
                String username = input.nextLine();
                System.out.print("Password: ");
                String password = input.nextLine();

                LoginModel loggedInAdmin = controller.loginAdmin(username, password);

                if (loggedInAdmin != null) {
                    handleAdminMenu();
                } else {
                    System.out.println("Invalid Admin credentials!\n");
                }
            }
        }
    }

    private static void handleAdminMenu() {
        while (true) {
            Display.AdminList();

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Logging out...\n");
                    return; // Exit to login
                case 1:
                    Register.RegisterFunction();
                    break;
                case 2:
                    controller.ViewAllAccounts();
                    break;
                case 3:
                    Deposit.DepositAmount();
                    break;
                case 4:
                    Delete.DeleteAccount();
                    break;
                default:
                    System.out.println("Invalid choice! Please Try again.");
            }
        }
    }

    private static void handleUserMenu(BankAccount loggedInUser) {
        while (true) {
            Display.UserDisplay();

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Logging out...\n");
                    return; // Exit to login
                case 1:
                    Widthdraw.WidthdrawAmount(loggedInUser);
                    break;
                case 2:
                    System.out.println("==== Your Savings Account Balance ====");
                    System.out.println("Account Id: " + loggedInUser.getAccountId());
                    System.out.println("Account Name: " + loggedInUser.getAccountName());
                    System.out.println("Account Balance: " + loggedInUser.getInitialSavings());
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
