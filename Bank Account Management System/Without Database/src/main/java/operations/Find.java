package operations;

import java.util.ArrayList;

import model.BankAccount;

public class Find {
	ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public Find (ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public BankAccount FindByAccount(int pinCode, String user) {
		for(BankAccount account : accounts) {
			if(account.getAccountName().equals(user) && account.getPinCode() == pinCode) {
				return account;
			}
		}
		
		return null;	
	}
	
	public BankAccount FindById(int accountId) {
		for(BankAccount account : accounts) {
			if(account.getAccountId() == accountId) {
				return account;
			}
		}
		return null;
	}
	
}
