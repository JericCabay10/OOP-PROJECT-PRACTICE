import java.util.*;

public class Main {
	static Scanner input = new Scanner(System.in);
	
	static String name;
	static int choice, id, pin;
	static double saving;
	
	public static void main(String[] args) {
		System.out.println("==== Welcome To Bank System ====");
		
		System.out.print("Username: ");
		String user = input.nextLine();
		System.out.print("Password: ");
		String pass = input.nextLine();
		
		if(user.equals("admin") && pass.equals("admin123")) {
			System.out.println("==== ADMIN VIEW ====");
			System.out.println("1. Register New Account");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Update Information");
			
			System.out.print("Choose: ");
			choice = input.nextInt();
			
			switch(choice) {
            case 0:
                System.out.println("Thank you for using our bank!");
                System.exit(0);
                break;
			case 1:
				System.out.println("==== Register New Account ====");
				
				System.out.print("Account id: ");
				id = input.nextInt();
				input.nextLine();
				
				System.out.print("Account name: ");
				name = input.nextLine();
				
				System.out.print("Initial savings: " );
				saving = input.nextDouble();
				
				System.out.print("Account pin: ");
				pin = input.nextInt();

				break;
			case 2:
				System.out.println("==== Deposit Amount ====");
				
				System.out.print("Enter Account id: ");
				id = input.nextInt();
				
				if(id == 123456) {
					while(true) {
						System.out.print("Enter amount: ");
						double amount = input.nextDouble();
					
						if(amount <= 999) {
							System.out.println("Amount is atleast 1000 amount");
						}else {
							System.out.println("Successully amount deposit");
							break;
						}
					}
				}
				
				break;
			case 3:
				System.out.println("==== View All Register Account ====");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} else if (user.equals("user") && pass.equals("user123")) {

	        while (true) {
	            System.out.println("==== Welcome To Bank ====");
	            System.out.println("1. Withdraw Amount");
	            System.out.println("2. Savings/Balance");
	            System.out.println("0. Exit");
	            System.out.print("Choose: ");
	            choice = input.nextInt();

	            switch (choice) {
	                case 1:
	                    while (true) { // 🔹 WITHDRAW MENU
	                        System.out.println("0. Go back ->");
	                        System.out.println("1. 300     2. 500");
	                        System.out.println("3. 800     4. 1000");
	                        System.out.println("5. 3000    6. 5000");
	                        System.out.print("Choose: ");
	                        choice = input.nextInt();

	                        if (choice == 0) { // Go back option
	                            System.out.println("Cancel withdraw amount?");
	                            System.out.println("0. Yes");
	                            System.out.println("1. No");
	                            System.out.print("Choose: ");
	                            choice = input.nextInt();

	                            if (choice == 0) {
	                                System.out.println("Returning to main menu...\n");
	                                break;
	                            } else {
	                                continue;
	                            }
	                        } else if (choice == 1) {
	                            System.out.println("Do you want to withdraw 300 pesos?");
	                        } else if (choice == 2) {
	                            System.out.println("Do you want to withdraw 500 pesos?");
	                        } else if (choice == 3) {
	                            System.out.println("Do you want to withdraw 800 pesos?");
	                        } else if (choice == 4) {
	                            System.out.println("Do you want to withdraw 1000 pesos?");
	                        } else if (choice == 5) {
	                            System.out.println("Do you want to withdraw 3000 pesos?");
	                        } else if (choice == 6) {
	                            System.out.println("Do you want to withdraw 5000 pesos?");
	                        } else {
	                            System.out.println("Invalid choice!");
	                        }
	                    }
	                    break;    
	                case 2:
	                    System.out.println("Your savings balance is ₱10,000\n");
	                    break;
	                default:
	                    System.out.println("Invalid choice!\n");
	            }
	        }

		}
	}
}
