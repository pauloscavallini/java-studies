package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();

        list.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
        list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
        list.add(new SavingsAccount(1003, "Bob", 300.0, 0.01));
        list.add(new BusinessAccount(1003, "Anna", 500.0, 500.0));

        double sum = 0.0;
        for (Account acc : list) {
            sum += acc.getBalance();
        }
        System.out.println(sum);

        for (Account acc : list) {
            acc.deposit(10.0);
            System.out.println("Updated balance for account " + acc.getNumber() + ": $" + acc.getBalance());
        }
    }
}
