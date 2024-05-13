package general;

import java.util.ArrayList;

public class CountAndSay {
    public String countAndSay(int n) {
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(1);

        for (int step = 1; step < n; step++) {
            ArrayList<Integer> nextSeq = new ArrayList<>();

            int counter = 1;
            for (int i = 0; i < seq.size() - 1; i++) {
                if (seq.get(i) == seq.get(i + 1)) {
                    counter++;
                } else {
                    nextSeq.add(counter);
                    nextSeq.add(seq.get(i));
                    counter = 1;
                }
            }
            nextSeq.add(counter);
            nextSeq.add(seq.get(seq.size() - 1));

            seq = nextSeq;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.size(); i++) {
            sb.append(seq.get(i));
        }
        return sb.toString();
    }

    //V2
    public static String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay2(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(count);
        sb.append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {

        int n1 = 4;
        System.out.println("Output 1: " + countAndSay(n1)); // Output: "1211"

        int n2 = 1;
        System.out.println("Output 2: " + countAndSay(n2)); // Output: "1"

    }
}
