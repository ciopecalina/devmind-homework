package sets;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }
        return (int) set.toArray()[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println("Output for [2, 2, 1]: " + singleNumber(nums1)); // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Output for [4, 1, 2, 1, 2]: " + singleNumber(nums2)); // Output: 4

        int[] nums3 = {1};
        System.out.println("Output for [1]: " + singleNumber(nums3)); // Output: 1

    }
}
