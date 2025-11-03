package operations;

import java.util.ArrayList;

import model.BankAccount;

public class Add {
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public Add(ArrayList<BankAccount> account) {
		this.accounts = account;
	}
	
	public void AddAcount(BankAccount account) {
		accounts.add(account);
		System.out.println("New account Register!");
	}
}
