package model;

public class BankAccount {
	private int accountId;
	private String accountName;
	private double savingsAccount;
	private String pinCode;
	
	//First Constructor
	public BankAccount(int accountId, String accountName, double savingsAccount, String pinCode) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.savingsAccount = savingsAccount;
		this.pinCode = pinCode;
	}
	
	//Second Constructor
	public BankAccount(int accountId) {
		this.accountId = accountId;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public void deposit(double amount) {
	    if (amount >= 1000) {
	        this.savingsAccount += amount;
	    } else {
	        System.out.println("The deposit must be at least ₱1000");
	    }
	}
	
	public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > this.savingsAccount) {
            System.out.println("Insufficient funds! Current balance: ₱" + this.savingsAccount);
        } else {
            this.savingsAccount -= amount;
            System.out.println("Withdrawal successful! New balance: ₱" + this.savingsAccount);
        }
    }
	
	public void DisplayInfo() {
		System.out.println();
		System.out.println("Account Id: " + this.accountId);
		System.out.println("Account name: " + this.accountName);
		System.out.println("Account savings: " + this.savingsAccount);
		System.out.println();
	}
}
