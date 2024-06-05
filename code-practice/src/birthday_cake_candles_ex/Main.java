package birthday_cake_candles_ex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function.
     *
     * The function expects to return an integer.
     * The function receives an array of integers as a parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int maxCounter = 0;

        for (int i = 0; i < candles.size(); i++) {
            int currentCounter = 0;
            int currentNumber = candles.get(i);

            for (int j = 0; j < candles.size(); j++) {
                if (candles.get(j) == currentNumber) {
                    currentCounter++;
                }
            }

            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
            }
        }

        return maxCounter;

    }

}

/*-----------------------------------------------------------
* The methods below are used for Testing Purposes only.
* Do not modify them.
-----------------------------------------------------------*/

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            myArray.add(x);
        }
        System.out.println(Result.birthdayCakeCandles(myArray));
    }
}

