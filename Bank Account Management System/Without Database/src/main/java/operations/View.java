package operations;

import java.util.ArrayList;

import model.BankAccount;

public class View {
ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public View(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public void ViewAllAccounts() {
		if(accounts.isEmpty()) {
			System.out.println("No account register!");
		}else {
			for(BankAccount account : accounts) {
				account.DisplayInfo();
			}
		}
	}
}
