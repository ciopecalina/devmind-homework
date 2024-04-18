package sets;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            set.add(number);
        }

        return (set.size() == nums.length) ? false : true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Output for nums = [1, 2, 3, 1]: " + containsDuplicate(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output for nums = [1, 2, 3, 4]: " + containsDuplicate(nums2)); // Output: false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Output for nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]: " + containsDuplicate(nums3)); // Output: true
    }
}
