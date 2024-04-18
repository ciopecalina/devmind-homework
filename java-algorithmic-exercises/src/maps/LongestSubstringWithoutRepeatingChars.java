package maps;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            max = Math.max(max, right - left + 1);
            map.put(c, right);
        }
        return max;
    }

    public static void main(String[] args) {

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Example 1 Output: " + lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Example 2 Output: " + lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Example 3 Output: " + lengthOfLongestSubstring(s3)); // Output: 3
    }
}
