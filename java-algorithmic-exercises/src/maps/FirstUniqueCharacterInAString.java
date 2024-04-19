package maps;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            //get the number of appearances of c
            //update the number of appearances of c
            int noOfAppearances = map.getOrDefault(c, 0);
            map.put(c, noOfAppearances + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "leetcode";
        System.out.println("Example 1 Output: " + firstUniqChar(s1)); // Output: 0

        String s2 = "loveleetcode";
        System.out.println("Example 2 Output: " + firstUniqChar(s2)); // Output: 2

        String s3 = "aabb";
        System.out.println("Example 3 Output: " + firstUniqChar(s3)); // Output: -1

        // Additional test cases
        String s4 = "abcde";
        System.out.println("Additional Test Case 1 Output: " + firstUniqChar(s4)); // Output: 0

        String s5 = "abccba";
        System.out.println("Additional Test Case 2 Output: " + firstUniqChar(s5)); // Output: -1

        String s6 = "aaaabbbbccccdddd";
        System.out.println("Additional Test Case 3 Output: " + firstUniqChar(s6)); // Output: -1

    }
}
