package sets;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int counter = 0;
        Set<Character> jewelsSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println("Output for jewels = \"aA\", stones = \"aAAbbbb\": " + numJewelsInStones(jewels1, stones1)); // Output: 3

        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println("Output for jewels = \"z\", stones = \"ZZ\": " + numJewelsInStones(jewels2, stones2)); // Output: 0

    }
}
