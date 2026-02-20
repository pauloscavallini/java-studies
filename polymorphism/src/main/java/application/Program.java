package application;

import entities.Account;
import entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Alex", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println("Balance x: " + x.getBalance());
        System.out.println("Balance y: " + y.getBalance());
    }
}
