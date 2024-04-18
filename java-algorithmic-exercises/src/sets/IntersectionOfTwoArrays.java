package sets;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1ToSet = new HashSet<>();
        for (int number : nums1) {
            nums1ToSet.add(number);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int number : nums2) {
            if (nums1ToSet.contains(number))
                resultSet.add(number);
        }

        int[] resultArray = new int[resultSet.size()];
        int i = 0;
        for (int number : resultSet) {
            resultArray[i++] = number;
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result1 = intersection(nums1, nums2);
        System.out.print("Output for nums1 = [1, 2, 2, 1], nums2 = [2, 2]: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: 2

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] result2 = intersection(nums3, nums4);
        System.out.print("Output for nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: 9 4
    }
}
