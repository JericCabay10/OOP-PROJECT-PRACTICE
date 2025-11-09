package controller;

import model.BankAccount;
import model.LoginModel;
import operations.*;

public class Controller {

    private Login adminLogin;
    private Login userLogin;
    private Add registerUser;
    private View viewAllAccounts;
    private Find findId;
    private Update updateAccountSaving;
    private Delete deleteUserAccount;

    public Controller() {
        adminLogin = new Login();
        userLogin = new Login();
        registerUser = new Add();
        viewAllAccounts = new View();
        findId = new Find();
        updateAccountSaving = new Update();
        deleteUserAccount = new Delete();
    }

    // Admin login
    public boolean authenticateAdmin(String username, String password) {
        LoginModel admin = new LoginModel(username, password);
        return adminLogin.AdminLogin(admin.getUsername(), admin.getPassword());
    }

    // User login
    public boolean authenticateUser(String pinCode) {
        LoginModel user = new LoginModel(pinCode);
        return userLogin.UserLogin(pinCode);
    }

    // Register new account
    public void RegisterAccount(BankAccount account) {
        registerUser.AddAcount(account);
    }

    // View all accounts
    public void ViewAllAccounts() {
        viewAllAccounts.ViewAllAccounts();
    }

    // Find account by ID
    public BankAccount FindByAccountId(int accountId) {
        return findId.FindAccountById(accountId);
    }

    // Update account balance in database
    public void UpdateAccount(BankAccount account) {
    	updateAccountSaving.UpdateAccount(account);
    }
    
    public void DeleteAccount(int accountId) {
    	deleteUserAccount.DeleteUser(accountId);
    }
}
