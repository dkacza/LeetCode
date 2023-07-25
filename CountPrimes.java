import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = false; sieve[1] = false;

        int range = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i < range; i++) {
            int number = i;
            while (true) {
                number += i;
                if (number >= n) break;
                sieve[number] = false;
            }
        }

        int result = 0;
        for (boolean prime : sieve) if (prime) result++;
        return result;
    }
}
