package general;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> list = new ArrayList<>();

        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();

            boolean inRow1 = true;
            boolean inRow2 = true;
            boolean inRow3 = true;

            for (int j = 0; j < lowerCaseWord.length(); j++) {
                char currentChar = lowerCaseWord.charAt(j);

                if (!row1.contains(String.valueOf(currentChar))) {
                    inRow1 = false;
                }
                if (!row2.contains(String.valueOf(currentChar))) {
                    inRow2 = false;
                }
                if (!row3.contains(String.valueOf(currentChar))) {
                    inRow3 = false;
                }
            }

            if (inRow1 || inRow2 || inRow3) {
                list.add(word);
            }
        }

        String[] result = list.toArray(new String[0]);
        return result;
    }

    public static void main(String[] args) {

    }
}
