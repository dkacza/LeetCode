// Problem 172 - Medium
// Factorial Trailing Zeroes

import java.util.ArrayList;
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        ArrayList<Integer> powersOfFive = new ArrayList<>();
        int power = 5;
        while (power < 10000) {
            powersOfFive.add(power);
            power *= 5;
        }

        int fives = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = i;
            for (int j = powersOfFive.size() - 1; j >= 0; j--) {
                if (tmp % powersOfFive.get(j) != 0) continue;
                fives += j + 1;
                tmp /= i;
            }
        }
        return fives;
    }
}
