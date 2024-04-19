package maps;

import java.util.*;

public class MinIndexSumOfTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = map.get(list2[i]) + i;
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear();
                    result.add(list2[i]);
                } else if (indexSum == minIndexSum) {
                    result.add(list2[i]);
                }
            }
        }

        // need 2 dynamically resize the array, when the size is not known
        //return result.toArray(new String[0]);

        // NO need 2 dynamically resize the array, when the size is known
        // -> efficient in terms of performance
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        // Test cases
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println("Example 1 Output: " + Arrays.toString(findRestaurant(list1, list2))); // Output: ["Shogun"]

        String[] list3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        System.out.println("Example 2 Output: " + Arrays.toString(findRestaurant(list3, list4))); // Output: ["Shogun"]

        String[] list5 = {"happy", "sad", "good"};
        String[] list6 = {"sad", "happy", "good"};
        System.out.println("Example 3 Output: " + Arrays.toString(findRestaurant(list5, list6))); // Output: ["sad", "happy"]

    }
}
