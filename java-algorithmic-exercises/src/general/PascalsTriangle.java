package general;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        result.add(new ArrayList<>(1));
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>(i + 2);
            for (int j = 0; j < i; j++) {
                int value = 0;
                if (j > 0) {
                    value += result.get(i - 1).get(j - 1);
                }
                if (j <= i - 1) {
                    value += result.get(i - 1).get(j);
                }
                row.add(value);
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }

    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int numRows1 = 5;
        List<List<Integer>> triangle1 = generate(numRows1);
        System.out.println("Pascal's Triangle for numRows = " + numRows1 + ":");
        printTriangle(triangle1);

        // Test Case 2
        int numRows2 = 1;
        List<List<Integer>> triangle2 = generate(numRows2);
        System.out.println("\nPascal's Triangle for numRows = " + numRows2 + ":");
        printTriangle(triangle2);
    }
}
