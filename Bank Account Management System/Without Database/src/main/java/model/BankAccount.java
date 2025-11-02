package model;

public class BankAccount {
	private int accountId;
	private String accountName;
	private double savingsAccount;
	private int pinCode;
	
	public BankAccount(int accountId, String accountName, double savingsAccount, int pinCode) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.savingsAccount = savingsAccount;
		this.pinCode = pinCode;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getInitialSavings() {
		return savingsAccount;
	}

	public void setInitialSavings(double savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
