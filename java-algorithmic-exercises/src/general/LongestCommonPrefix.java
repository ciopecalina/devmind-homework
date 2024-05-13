package general;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int resultLength = 0;

        for (int i = 0; i < (first.length() < last.length() ? first.length() : last.length()); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                resultLength++;
            } else break;
        }

        return first.substring(0, resultLength);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car", "fiiiiiiiiii"};
        String[] strs3 = new String[]{"9914", "93456", "999910000"};

        System.out.println(longestCommonPrefix(strs));
    }
}

