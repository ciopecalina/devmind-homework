package maps;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    //the longest palindrome that CAN be built with those letters
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cFrequency = map.getOrDefault(c, 0);
            map.put(c, cFrequency + 1);
        }

        int maxLength = 0;
        boolean isCharFreqOdd = false;

        // Iterate through the entries of the map
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            // Get the count of the current character
            int charFreq = entry.getValue();
            // If the count is even, add it directly to the maxLength
            if (charFreq % 2 == 0) {
                maxLength += charFreq;
            } else {
                maxLength += charFreq - 1;
                isCharFreqOdd = true;
            }
        }
        if(isCharFreqOdd == true)
        {
            maxLength++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abccccdd";
        System.out.println("Example 1 Output: " + longestPalindrome(s1)); // Output: 7

        String s2 = "a";
        System.out.println("Example 2 Output: " + longestPalindrome(s2)); // Output: 1

        String s3 = "Aa";
        System.out.println("Example 3 Output: " + longestPalindrome(s3)); // Output: 1 (Case sensitive, "A" or "a")

        // Additional test cases
        String s4 = "racecar";
        System.out.println("Additional Test Case 1 Output: " + longestPalindrome(s4)); // Output: 7 (The string is already a palindrome)

        String s5 = "abcd";
        System.out.println("Additional Test Case 2 Output: " + longestPalindrome(s5)); // Output: 1 (No palindrome can be built)

        String s6 = "abBA";
        System.out.println("Additional Test Case 3 Output: " + longestPalindrome(s6)); // Output: 1

    }
}
