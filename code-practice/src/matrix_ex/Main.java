package matrix_ex;

import java.util.Scanner;

class Solution {
    public void fillInMatrix(String matrix[][], int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i + j >= n - 1) {
                    matrix[i][j] = "#";
                } else {
                    matrix[i][j] = " ";
                }
            }
    }

    public void printMatrix(String matrix[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] matrix = new String[n][n];

        solution.fillInMatrix(matrix, n);
        solution.printMatrix(matrix, n);

    }
}
