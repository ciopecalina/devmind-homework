package binary_search;

public class FirstLastPositionOfElementInSortedArray {
    public static int searchLeftIndex(int[] nums, int target) {
        int leftIndex = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                leftIndex = middle;
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return leftIndex;
    }

    public static int searchRightIndex(int[] nums, int target) {
        int rightIndex = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                rightIndex = middle;
                left = middle + 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return rightIndex;
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeftIndex(nums, target);
        int rightIndex = searchRightIndex(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Output 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Output 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Output 3: [" + result3[0] + ", " + result3[1] + "]");

    }
}
