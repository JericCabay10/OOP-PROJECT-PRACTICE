import java.sql.Connection;

import java.util.*;
import controller.Controller;
import model.BankAccount;

import statics.List;


public class Main {
    static Scanner input = new Scanner(System.in);
    static Controller controller = new Controller();
    
    static boolean isAuthenticatedUser = false;
    static boolean isAuthenticatedAdmin = false;
    static boolean isUserFound = false;
    
    static String name, username, password;
    static int choice, id;
    static double saving, amount;
    static BankAccount userAccount;
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Welcome To Bank System ====");
            
            System.out.print("Press (Y/y) to start: ");
            char press = input.next().charAt(0);
            input.nextLine();
            
            if(press == 'Y' || press == 'y') {
            	System.out.print("Pin Code: ");
                password = input.nextLine();
                
                isAuthenticatedUser = controller.authenticateUser(password);
            }else if(press == '1') {
                System.out.print("Username: ");
                username = input.nextLine();
                System.out.print("Password: ");
                password = input.nextLine();
                
                isAuthenticatedAdmin = controller.authenticateAdmin(username, password);
            }
            

            if (isAuthenticatedAdmin) {
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
                            password = input.nextLine();
                            input.nextLine();

                            BankAccount account = new BankAccount(id, name, saving, password);
                            controller.RegisterAccount(account);
                            
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

                        	BankAccount accountToDeposit = controller.FindByAccountId(id);

                        	if (accountToDeposit != null) {
                        	    System.out.print("Enter amount: ");
                        	    double amount = input.nextDouble();
                        	    input.nextLine();

                        	    accountToDeposit.deposit(amount);
                        	    controller.UpdateAccount(accountToDeposit); 

                        	} else {
                        	    System.out.println("Invalid Account ID!\n");
                        	}

                            break;
                        case 4:
                            System.out.println("==== DELETE USER ACCOUNT ====\n");
                            System.out.print("Enter account Id: ");
                            id = input.nextInt();
                            
                            controller.DeleteAccount(id);
                            break;
                        default:
                            System.out.println("Invalid choice!\n");
                    }

                    if (choice == 0) break; // 🔹 Logout to main login
                }

            } else if(isAuthenticatedUser) {
            	while(true) {
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
