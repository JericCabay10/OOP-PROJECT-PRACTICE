package util;

import java.util.*;
import controller.Controller;
import model.BankAccount;

public class Widthdraw {
    static Scanner input = new Scanner(System.in);
    static Controller controller = new Controller();

    // Pass the logged-in BankAccount object
    public static void WidthdrawAmount(BankAccount account) {
        while (true) {
            System.out.println("\n==== WITHDRAW MENU ====");
            System.out.print("Enter an amount or 0: ");
            int amount = input.nextInt();

            if (amount == 0) {
                System.out.println("Returning to main menu...");
                break;
            } else if (amount >= 100) {

                if (account.getInitialSavings() < amount) {
                    System.out.println("⚠️ Insufficient balance!");
                } else {
                    account.withdraw(amount);
                    controller.UpdateAccount(account);

                    System.out.println("✅ You withdrew ₱" + amount);
                    System.out.println("💰 New Balance: ₱" + account.getInitialSavings());
                }
            } else {
                System.out.println("The amount atleast 100 ");
            }
        }
    }
}
