package matrices;

import java.util.Scanner;

public class MatriceSpirala {
    private static int[][] spiralMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] mat = spiralMatrix(n, m);

        for (int[] row : mat) {
            for (int num : row) {
                if (num < 10) System.out.print(" " + num + " ");
                else System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
