package general;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int readIt = 1, writeIt = 0;

        while (readIt < nums.length) {
            if (nums[readIt] != nums[writeIt]) {
                nums[writeIt+1] = nums[readIt];
                writeIt++;
            }
            readIt++;
        }

        return writeIt + 1;
    }


    private static String arrayToString(int[] nums, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(nums[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int expectedLength1 = 2;
        int actualLength1 = removeDuplicates(nums1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Length: " + expectedLength1);
        System.out.println("Actual Length: " + actualLength1);
        System.out.println("Resulting Array: " + arrayToString(nums1, actualLength1));

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expectedLength2 = 5;
        int actualLength2 = removeDuplicates(nums2);
        System.out.println("\nTest Case 2:");
        System.out.println("Expected Length: " + expectedLength2);
        System.out.println("Actual Length: " + actualLength2);
        System.out.println("Resulting Array: " + arrayToString(nums2, actualLength2));

    }
}
