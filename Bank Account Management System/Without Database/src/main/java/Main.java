import java.util.*;

import controller.BankAccountController;
import model.BankAccount;

import statics.List;

public class Main {
    static Scanner input = new Scanner(System.in);
    static BankAccountController controller = new BankAccountController();
    
    
    
    static String name, user;
    static int choice, id, pin;
    static double saving, amount;
    static BankAccount userAccount;
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Welcome To Bank System ====");
      
            
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String pass = input.nextLine();

            if (user.equals("admin") && pass.equals("123") || user.equals("root") && pass.equals("1234")) {
                while (true) {
                    List.AdminList();

                    System.out.print("Choose: ");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 0:
                            System.out.println("Logging out...\n");
                            break; // Exit to login
                        case 1:
                            System.out.println("==== Register New Account ====");
                            System.out.print("Account id: ");
                            id = input.nextInt();
                            input.nextLine();

                            System.out.print("Account name: ");
                            name = input.nextLine();

                            System.out.print("Initial savings: ");
                            saving = input.nextDouble();

                            System.out.print("Account pin: ");
                            pin = input.nextInt();
                            input.nextLine();

                            BankAccount account = new BankAccount(id, name, saving, pin);
                            controller.AddAccount(account);
                            
                            System.out.println("Account registered successfully!\n");
                            break;
                        case 2:
                        	controller.ViewAllAccounts();
                        	break;
                        case 3:
                            System.out.println("==== Deposit Amount ====");
                            System.out.print("Enter Account id: ");
                            id = input.nextInt();
                            input.nextLine();

                            BankAccount accountToDeposit = controller.FindById(id);
                            if (accountToDeposit != null) {
                                    System.out.print("Enter amount: ");
                                    double amount = input.nextDouble();
                                    
                                    accountToDeposit.deposit(amount);
                            } else {
                                System.out.println("Invalid Account ID!\n");
                            }
                            break;
                        case 4:
                            System.out.println("==== View All Registered Accounts ====\n");
                            break;
                        default:
                            System.out.println("Invalid choice!\n");
                    }

                    if (choice == 0) break; // 🔹 Logout to main login
                }

            } else if (controller.FindTheAccount( pin, user) != null) {
            	userAccount = controller.FindTheAccount( pin, user);
            	
            	while (true) {
                    System.out.println("\n==== USER MENU ====");
                    System.out.println("0. Logout");
                    System.out.println("1. Withdraw Amount");
                    System.out.println("2. Check Balance");
                    System.out.print("Choose: ");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 0:
                            System.out.println("Logging out...\n");
                            break;
                        case 1:
                            while (true) {
                                System.out.println("\n==== WITHDRAW MENU ====");
                                System.out.println("0. Go back");
                                System.out.println("1. 300     2. 500");
                                System.out.println("3. 800     4. 1000");
                                System.out.println("5. 4000    6. 5000");
                                System.out.print("Choose: ");
                                int withdrawChoice = input.nextInt();
                                
                                int[] amounts = {300, 500, 800, 1000, 4000, 5000};

                                if (withdrawChoice == 0) {
                                    System.out.println("Returning to main menu...\n");
                                    break;
                                } else if (withdrawChoice >= 1 && withdrawChoice <= 6) {
                                    double amountToWithdraw = amounts[withdrawChoice - 1];
                                    userAccount.withdraw(amountToWithdraw);
                                } else {
                                    System.out.println("Invalid choice!\n");
                                }
                            }
                            break;
                        case 2:
                        	System.out.println("==== Your Savings Account Balance ====");
                        	
                            System.out.println("Account Id: " + userAccount.getAccountId());
                            System.out.println("Account Name: " + userAccount.getAccountName());
                            System.out.println("Account Balance: " + userAccount.getInitialSavings());
                            break;
                        default:
                            System.out.println("Invalid choice!\n");
                    }

                    if (choice == 0) { 
                    	break;
                    }
                }
            } else {
                System.out.println("Invalid username or password!\n");
            }
        }
    }
}
