// Problem 2448
// Minimum cost to make array equal

import java.util.HashSet;
import java.util.Set;

public class CostToMakeArrayEqual {
    public static long minCost(int[] nums, int[] cost) {
        // 0. If costs are the same and values are linearly increasing calculate the area of triangle
        Set<Integer> costs = new HashSet<>();
        boolean isLinear = true;
        for (int singleCost : cost) costs.add(singleCost);
        if (costs.size() == 1) {
            int previousVal = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] -  previousVal != 1) {
                    isLinear = false;
                    break;
                }
                previousVal = nums[i];
            }

            if (isLinear) {
                int height = nums[nums.length / 2 - 1];
                int width = nums[nums.length - 1];
                return (long) width * height * cost[0] / 2;
            }
        }

        // 1. Sort nums and costs.
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;

            int tmpCost = cost[i];
            cost[i] = cost[minIndex];
            cost[minIndex] = tmpCost;
        }

        // Iterate through every value
        long totalSum = 0;
        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int newValue = nums[i]; // We flatten the array into new value
            int prefixEndIndex = i - 1;
            int postfixStartIndex = i + 1;
            int difference = i > 0 ? Math.abs(nums[i - 1] - newValue) : nums[0];

            // Calculate for first iteration
            if (i == 0) {
                for (int r = postfixStartIndex; r < nums.length; r++) {
                    totalSum += (long) Math.abs(nums[r] - newValue) * cost[r];
                }
                if (totalSum < minSum) minSum = totalSum;
                continue;
            }
            // Add to the sum from the left
            for (int l = 0; l <= prefixEndIndex; l++) {
                totalSum += (long) difference * cost[l];
            }
            // Subtract from the right
            for (int r = postfixStartIndex - 1; r < nums.length; r++) {
                totalSum -= (long) difference * cost[r];
            }
            if (totalSum < minSum) minSum = totalSum;
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 10};
        int[] cost = new int[] {2, 1};
        long total = minCost(nums, cost);
        System.out.println(total);
    }
}
