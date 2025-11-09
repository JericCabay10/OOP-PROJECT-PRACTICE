package util;

import java.util.*;

import controller.Controller;

public class Delete {
	static Scanner input = new Scanner(System.in);
	static Controller controller = new Controller();
	
	public static void DeleteAccount() {
		System.out.println("==== DELETE USER ACCOUNT ====\n");
        System.out.print("Enter account Id: ");
        int id = input.nextInt();
        
        controller.DeleteAccount(id);
	}
}
