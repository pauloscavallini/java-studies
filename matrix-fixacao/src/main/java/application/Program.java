package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // quero buscar informações sobre cada item com dado valor
        int value = sc.nextInt(); // valor a ser buscado

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!(matrix[i][j] == value)) {continue;}

                System.out.printf("Position %d,%d:%n", i, j);

                // left
                if (j - 1 >= 0) {
                    System.out.println("Left: " + matrix[i][j - 1]);
                }

                // right
                if (j + 1 < matrix[i].length) {
                    System.out.println("Right: " + matrix[i][j + 1]);
                }

                // up
                if (i - 1 >= 0 && j < matrix[i - 1].length) {
                    System.out.println("Up: " + matrix[i - 1][j]);
                }

                // bottom
                if (i + 1 < matrix.length && j < matrix[i + 1].length) {
                    System.out.println("Bottom: " + matrix[i + 1][j]);
                }
            }
        }

        sc.close();
    }
}
