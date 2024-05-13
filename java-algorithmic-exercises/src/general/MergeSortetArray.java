package general;

public class MergeSortetArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;

        while (n >= 0) {
            if (m < 0 || nums1[m] < nums2[n]) {
                nums1[n + m + 1] = nums2[n];
                n--;
            } else {
                nums1[n + m + 1] = nums1[m];
                m--;
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        printArray(nums1); // Output: [1,2,2,3,5,6]

        int[] nums3 = {1};
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        merge(nums3, m2, nums4, n2);
        printArray(nums3); // Output: [1]

        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1;
        merge(nums5, m3, nums6, n3);
        printArray(nums5); // Output: [1]
    }
}
