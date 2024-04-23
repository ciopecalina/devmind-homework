package binary_search;

public class SquareRootOfx {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        long left = 1;
        long right = x;

        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {

    }
}
