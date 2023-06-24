// Problem 956 - Hard
// Tallest Billboard

import java.util.Arrays;
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) sum+= rod;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int rod : rods) {
            int[] current = dp.clone();
            for (int i = 0; i <= sum - rod; i++) {
                if (current[i] < 0) continue;
                dp[i + rod] = Math.max(dp[i + rod], current[i]);
                dp[Math.abs(i - rod)] = Math.max(dp[Math.abs(i - rod)], current[i] + Math.min(i, rod));
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        TallestBillboard solution = new TallestBillboard();
        int[] rods = new int[] {104,104,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,98};
        int result = solution.tallestBillboard(rods);
        System.out.println(result);
    }
}
