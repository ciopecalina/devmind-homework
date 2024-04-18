package sets;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        int maxNoOfDiffTypes = 0;
        int maxNoOfCandies = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) {
            set.add(type);
        }
        maxNoOfDiffTypes = set.size();

        return Math.min(maxNoOfCandies, maxNoOfDiffTypes);
    }

    public static void main(String[] args) {

        int[] candyType1 = {1, 1, 2, 2, 3, 3};
        System.out.println("Output for candyType = [1, 1, 2, 2, 3, 3]: " + distributeCandies(candyType1)); // Output: 3

        int[] candyType2 = {1, 1, 2, 3};
        System.out.println("Output for candyType = [1, 1, 2, 3]: " + distributeCandies(candyType2)); // Output: 2

        int[] candyType3 = {6, 6, 6, 6};
        System.out.println("Output for candyType = [6, 6, 6, 6]: " + distributeCandies(candyType3)); // Output: 1
    }
}
