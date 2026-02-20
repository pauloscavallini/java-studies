package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Quantos funcionarios? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data");

            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Horas trabalhadas: ");
            int hours = sc.nextInt();
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();

            Employee emp;
            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double charge = sc.nextDouble();
                emp = new OutsourcedEmployee(name, hours, valuePerHour, charge);
            } else {
                emp = new Employee(name, hours, valuePerHour);
            }

            employees.add(emp);
        }

        System.out.println("\nPAYMENTS: ");
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }
}