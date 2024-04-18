package maps;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        Integer counter;
        for (char c : s.toCharArray()) {
            counter = mapS.getOrDefault(c, 0);
            mapS.put(c, counter + 1);
        }
        for (char c : t.toCharArray()) {
            counter = mapT.getOrDefault(c, 0);
            mapT.put(c, counter + 1);
        }

        return mapS.equals(mapT);
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Example 1 Output: " + isAnagram(s1, t1)); // Output: true

        // Example 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Example 2 Output: " + isAnagram(s2, t2)); // Output: false

    }
}