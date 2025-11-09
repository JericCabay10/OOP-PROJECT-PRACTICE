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

    public LoginModel loginAdmin(String username, String password) {
        return adminLogin.AdminLogin(username, password);
    }

    public BankAccount loginUser(String pinCode) {
        return userLogin.UserLogin(pinCode);
    }

    public void RegisterAccount(BankAccount account) {
        registerUser.AddAcount(account);
    }

    public void ViewAllAccounts() {
        viewAllAccounts.ViewAllAccounts();
    }

    public BankAccount FindByAccountId(int accountId) {
        return findId.FindAccountById(accountId);
    }

    public void UpdateAccount(BankAccount account) {
        updateAccountSaving.UpdateAccount(account);
    }

    public void DeleteAccount(int accountId) {
        deleteUserAccount.DeleteUser(accountId);
    }
}
