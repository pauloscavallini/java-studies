package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:");

            System.out.print("Rectangle or Circle (r/c)? ");
            sc.nextLine();
            char resp = sc.next().charAt(0);

            System.out.print("Color (BLACK/BLUE/RED): ");
//            sc.nextLine();
            Color color = Color.valueOf(sc.next());

            Shape shape;
            if (resp == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                shape = new Rectangle(color, width, height);
            } else {
                System.out.print("Radius: ");
                shape = new Circle(color, sc.nextDouble());
            }

            list.add(shape);
        }

        System.out.println("\nSHAPE AREAS:");
        for (Shape sh : list) {
            System.out.printf("%.2f%n", sh.area());
        }

        sc.close();
    }
}