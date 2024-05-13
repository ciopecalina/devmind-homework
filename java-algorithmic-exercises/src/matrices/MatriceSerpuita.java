package matrices;

import java.util.Scanner;

public class MatriceSerpuita {
    private static int[][] horizDec(int n, int m) {
        int[][] matrix = new int[n][m];
        int num = 1;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = num++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    matrix[i][j] = num++;
                }
            }
        }
        return matrix;

    }

    private static int[][] vertInc(int n, int m) {
        int[][] matrix = new int[n][m];
        int num = 1;
        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = num++;
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    matrix[i][j] = num++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // initialize it with something
        int[][] mat = new int[1][1];

        switch (a) {
            case 1:
                mat = horizDec(n, m);
                break;
            case 2:
                mat = vertInc(n, m);
                break;
        }

        for (int[] row : mat) {
            for (int num : row) {
                if (num < 10) System.out.print(" " + num + " ");
                else System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

