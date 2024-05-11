package binary_search;

public class FirstLastPositionOfElementInSortedArray {
    public searchLeftIndex(int[] nums, int target) {
        int leftIndex = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                leftIndex = middle;
                right = middle - 1;
            } else if () {

            }

        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeftIndex(nums, target);
        int rightIndex = searchRightIndex(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {

    }
}
