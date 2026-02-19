package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING
//        List<Account> contas = new ArrayList<>();

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

//        contas.add(bacc); // upcasting automatico

        // DOWNCASTING

        // não vai deixar por levar o tipo da superclasse em consideração - ignorando os métodos da subclasse
//         acc2.loan(100.0);

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

//        BusinessAccount acc5 = (BusinessAccount) acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) { // verifica o tipo da subclasse onde Account é extended
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Updated!");
        }
    }
}
