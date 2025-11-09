package display;

public class Display {
	public static void AdminList() {
		System.out.println("\n==== ADMIN VIEW ====");
        System.out.println("0. Logout -->");
        System.out.println("1. Register New Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Delete Account");
	}
	
	public static void UserDisplay() {
		System.out.println("\n==== USER MENU ====");
        System.out.println("0. Logout");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Check Balance");
	}
} 
