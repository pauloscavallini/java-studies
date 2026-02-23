package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> payerList = new ArrayList<>();

//        for (TaxPayer tp : payerList) {
//            System.out.println(tp.tax());
//        }

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or company (i/c)? ");
            char tipo = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double income = sc.nextDouble();

            TaxPayer tp;
            if (tipo == 'i') {
                System.out.print("Health expenditures: ");
                tp = new Individual(name, income, sc.nextDouble());
            } else {
                System.out.print("Number of employees: ");
                tp = new Company(name, income, sc.nextInt());
            }
            payerList.add(tp);
        }

        double taxesSum = 0.0;

        System.out.println("\nTAXES PAID:");
        for (TaxPayer tp : payerList) {
            double tax = tp.tax();
            taxesSum += tax;
            System.out.printf("%s: $%.2f\n", tp.getName(), tax);
        }

        System.out.printf("\nTOTAL TAXES: $%.2f%n", taxesSum);

        sc.close();
    }
}
