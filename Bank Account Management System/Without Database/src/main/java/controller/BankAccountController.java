package controller;

import java.util.ArrayList;

import model.BankAccount;

import operations.*;

public class BankAccountController {
	
	ArrayList<BankAccount> accounts = new ArrayList<>();

	Add add = new Add(accounts);
	View viewAll = new View(accounts); 
	Find findByAccount = new Find(accounts);
	
	Find findById = new Find(accounts);
	
	public void AddAccount(BankAccount b) {
		add.AddAcount(b);
	}
	
	public void ViewAllAccounts() {
		viewAll.ViewAllAccounts();
	}
	
	public BankAccount FindTheAccount(int pinCode, String user) {
		return findByAccount.FindByAccount(pinCode, user);
	}
	
	public BankAccount FindById(int accountId) {
		return findById.FindById(accountId);
	}
}
