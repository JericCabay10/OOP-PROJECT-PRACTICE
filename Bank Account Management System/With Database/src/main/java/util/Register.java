package util;

import java.util.*;

import controller.Controller;
import model.BankAccount;

public class Register {
	static Scanner input = new Scanner(System.in);
	static Controller controller = new Controller();
	
	 public static void RegisterFunction() {
		 System.out.println("==== Register New Account ====");
	     System.out.print("Account id: ");
	     int id = input.nextInt();
	     input.nextLine();

	     System.out.print("Account name: ");
	     String name = input.nextLine();

	     System.out.print("Initial savings: ");
	     double saving = input.nextDouble();

	     System.out.print("Account pin: ");
	     String password = input.nextLine();
	     input.nextLine();

	     BankAccount account = new BankAccount(id, name, saving, password);
	     controller.RegisterAccount(account);
	     
	     System.out.println("Account registered successfully!\n");
	 }
}
