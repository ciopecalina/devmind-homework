package maps;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : nums1) {
            int freqOfNo = map.getOrDefault(number, 0);
            map.put(number, freqOfNo + 1);
        }
        for (int number : nums2) {
            if (map.containsKey(number) && map.get(number) > 0) {
                resultList.add(number);
                map.put(number, map.get(number) - 1);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Example 1 Output: " + Arrays.toString(intersect(nums1, nums2))); // Output: [2, 2]

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println("Example 2 Output: " + Arrays.toString(intersect(nums3, nums4))); // Output: [4, 9] or [9, 4]

        // Additional test cases
        int[] nums5 = {1, 1, 2, 2};
        int[] nums6 = {2, 2, 3, 3};
        System.out.println("Additional Test Case 1 Output: " + Arrays.toString(intersect(nums5, nums6))); // Output: [2, 2]

        int[] nums7 = {1, 2, 3};
        int[] nums8 = {4, 5, 6};
        System.out.println("Additional Test Case 2 Output: " + Arrays.toString(intersect(nums7, nums8))); // Output: []

        int[] nums9 = {1, 2, 2, 1};
        int[] nums10 = {2};
        System.out.println("Additional Test Case 3 Output: " + Arrays.toString(intersect(nums9, nums10))); // Output: [2]

        int[] nums11 = {1, 2, 3, 4};
        int[] nums12 = {5, 6, 7, 8};
        System.out.println("Additional Test Case 4 Output: " + Arrays.toString(intersect(nums11, nums12))); // Output: []

    }
}
