package binary_search;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num < 1)
            return false;

        if (num == 1)
            return true;

        long left = 1, right = num;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            long square = middle * middle;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {16, 14, 1, 81, 25, 37};
        for (int num : testCases) {
            System.out.println("Is " + num + " a perfect square? " + isPerfectSquare(num));

        }
    }
}
