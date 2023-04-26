package Task01FillTheMatrix;

import java.util.Scanner;

/**
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);                   //number of rows and columns

        if (input[1].equals("A")){
            DisplayMatrix(n,MatrixPatternA(n));
        }else if (input[1].equals("B")){
            DisplayMatrix(n,MatrixPatternB(n));
        }
    }

    public static int[][] MatrixPatternA(int n) {
        int[][] matrixA = new int[n][n];
        int counterA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[j][i] = ++counterA;
            }
        }
        return matrixA;
    }

    public static int[][] MatrixPatternB(int n) {
        int[][] matrixB = new int[n][n];
        int counterB=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    matrixB[j][i] = counterB++;
                } else {
                    matrixB[j][i] = counterB--;
                }
            }
            if (i % 2 == 0) {
                counterB += n - 1;
            } else {
                counterB += n + 1;
            }
        }
        return matrixB;
    }

    public static void DisplayMatrix(int n, int[][] inputMatrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(inputMatrix[i][j]);
                if (j!=n-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
