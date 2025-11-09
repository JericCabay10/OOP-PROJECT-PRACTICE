package util;

import java.util.*;

import controller.Controller;
import model.BankAccount;

public class Deposit {
	static Scanner input = new Scanner(System.in);
	static Controller controller = new Controller();
	
	public static void DepositAmount() {
		System.out.println("==== Deposit Amount ====");
    	System.out.print("Enter Account id: ");
    	int id = input.nextInt();
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
	}
}
