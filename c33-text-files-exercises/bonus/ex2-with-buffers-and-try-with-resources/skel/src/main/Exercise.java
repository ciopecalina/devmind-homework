package main;

public class Exercise {
    public String solve(String nums1[], String[] nums2) {
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            int num1 = Integer.parseInt(nums1[i]);
            int num2 = Integer.parseInt(nums2[j]);

            if (num1 < num2) {
                result.append(num1 + " ");
                i++;
            } else {
                result.append(num2 + " ");
                j++;
            }
        }

        // Remaining elements of nums1
        while (i < nums1.length) {
            result.append(nums1[i] + " ");
            i++;
        }

        // Remaining elements of nums2
        while (j < nums2.length) {
            result.append(nums2[j] + " ");
            j++;
        }

        return result.toString();
    }
}
