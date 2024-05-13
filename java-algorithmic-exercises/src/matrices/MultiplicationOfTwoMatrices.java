package matrices;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiplicationOfTwoMatrices {
    private static int[][] arrayMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue, int centerValue,
                                       int leftValue, int upValue, int rightValue, int bottomValue) {
        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = mainDiagValue;
                }
                if (i + j == matrixDimension - 1) {
                    matrix[i][j] = sndDiagValue;
                }
                if ((i + j < matrixDimension - 1) && (i < j)) {
                    matrix[i][j] = upValue;
                }
                if ((i + j > matrixDimension - 1) && (i > j)) {
                    matrix[i][j] = bottomValue;
                }
                if ((i > j) && (i + j < matrixDimension - 1)) {
                    matrix[i][j] = leftValue;
                }
                if ((i < j) && (i + j > matrixDimension - 1)) {
                    matrix[i][j] = rightValue;
                }
            }
        }

        if (matrixDimension % 2 != 0) {
            matrix[matrixDimension / 2][matrixDimension / 2] = centerValue;
        }

        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> arrayListMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue,
                                                                 int centerValue, int leftValue, int upValue, int rightValue, int bottomValue) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < matrixDimension; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < matrixDimension; j++) {
                if (i == j) {
                    newRow.add(mainDiagValue);
                } else if (i + j == matrixDimension - 1) {
                    newRow.add(sndDiagValue);
                } else if (i < j && i + j < matrixDimension - 1) {
                    newRow.add(upValue);
                } else if (i > j && i + j > matrixDimension - 1) {
                    newRow.add(bottomValue);
                } else if (i > j && i + j < matrixDimension - 1) {
                    newRow.add(leftValue);
                } else if (i < j && i + j > matrixDimension - 1) {
                    newRow.add(rightValue);
                }
            }
            matrix.add(newRow);
        }

        if (matrixDimension % 2 != 0) {
            int centerIndex = matrixDimension / 2;
            matrix.get(centerIndex).set(centerIndex, centerValue);
        }

        return matrix;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseV = scanner.nextInt();

        int matrixDimension = scanner.nextInt();
        int mainDiagValue = scanner.nextInt();
        int sndDiagValue = scanner.nextInt();
        int centerValue = 0;
        if (matrixDimension % 2 != 0)
            centerValue = scanner.nextInt();
        int leftValue = scanner.nextInt();
        int upValue = scanner.nextInt();
        int rightValue = scanner.nextInt();
        int bottomValue = scanner.nextInt();

        switch (caseV) {
            case 1:
                // arrays
                int[][] array = arrayMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (int[] row : array) {
                    for (int elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                // ArrayList
                ArrayList<ArrayList<Integer>> arrayList =
                        arrayListMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (ArrayList<Integer> row : arrayList) {
                    for (Integer elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}

