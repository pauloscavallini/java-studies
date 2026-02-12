package application;

import entities.Employee;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("%nEmployee #%d:%n", i+1);

            System.out.print("Id: ");
            int id = sc.nextInt();

            while (hasId(employees, id)) {
                System.out.print("Id already taken, try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.printf("%nEnter the employee id that will have salary increase: ");
        int increaseId = sc.nextInt();

        Employee increaseEmployee = employees.stream()
                .filter(x -> x.getId() == increaseId)
                .findFirst()
                .orElse(null);

        if (increaseEmployee == null) {
            System.out.println("This employee does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            increaseEmployee.increaseSalary(percentage);
        }

        System.out.printf("%nList of employees: %n");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
       Employee emp = list.stream()
               .filter(x -> x.getId() == id)
               .findFirst()
               .orElse(null);

       return emp != null;
    }
}
