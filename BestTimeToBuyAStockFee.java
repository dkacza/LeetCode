// Problem 714 - Medium
// Best Time to Buy and Sell Stock with Transaction Fee
class BestTimeToBuyAStockFree {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n];
        int[] hold = new int[n];

        free[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return free[n - 1];
    }
}