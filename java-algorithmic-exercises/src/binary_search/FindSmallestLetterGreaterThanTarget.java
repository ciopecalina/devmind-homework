package binary_search;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (letters[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (left == letters.length) {
            return letters[0];
        }
        return letters[left];
    }

    public static void main(String[] args) {
        // Test cases
        char[][] testLetters = {{'c', 'f', 'j'}, {'c', 'f', 'j'}, {'x', 'x', 'y', 'y'}};
        char[] targets = {'a', 'c', 'z'};
        for (int i = 0; i < testLetters.length; i++) {
            char result = nextGreatestLetter(testLetters[i], targets[i]);
            System.out.println("For input: letters = "
                    + Arrays.toString(testLetters[i]) + ", target = '" + targets[i] + "', output: '" + result + "'");
        }
    }
}
