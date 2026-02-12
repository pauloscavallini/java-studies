package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        {
            /*
             * - [Vetor]:
             * + estrutura homogênea (só aceita dados do mesmo tipo)
             * + tamanho fixo
             *
             * */

            int[] myVect = new int[10];
            myVect[2] = 10;

//            for (int i : myVect) {
//                System.out.println(i);
//            }
        }

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] vetor = new double[n]; // mesmo tendo tamanho 3, o index vai chega até 2, sendo [0, 1, 2]

        // atribuindo valor aos campos
        for (int i = 0; i < n; i++) {
            vetor[i] = sc.nextDouble();
        }

        double sum = 0.0;
        for (double i : vetor) {
            sum += i;
        }
        double avg = sum/n; // obtendo média

        System.out.printf("AVERAGE = %.2f%n", avg);

        sc.close();
    }
}