package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char tipo = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product;
            if (tipo == 'c') {
                product = new Product(name, price);
            } else if (tipo == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                product = new UsedProduct(name, price, sdf.parse(sc.nextLine()));
            } else {
                System.out.print("Customs fee: ");
                product = new ImportedProduct(name, price, sc.nextDouble());
            }
            products.add(product);
        }

        System.out.println("\nPRICE TAGS: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}