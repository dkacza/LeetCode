// Problem 2090
// K Radius Subarray Averages

import java.util.Arrays;

public class KRadiusSubarrayAvg {
    public int[] getAverages(int[] nums, int k) {
        int[] averages = new int[nums.length];
        int windowSize = 2 * k + 1;

        // Check if the window of numbers fits within the array
        if (windowSize > nums.length) {
            Arrays.fill(averages, -1);
            return averages;
        }
        // Check if the radius is equal to zero
        if (k == 0) {
            return nums;
        }

        // Array of sums
        // Check if the array contains only one value
        long[] sums = new long[nums.length];
        long previousSum = 0;
        long previousElement = 0;
        boolean onlyOne = true;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = previousSum + nums[i];
            previousSum = sums[i];
            if (i >= 1) {
                if (previousElement != nums[i]) onlyOne = false;
            }
            previousElement = nums[i];
        }

        // Iterate through averages array and fill it
        for (int i = 0; i < averages.length; i++) {
            int startIndex = i - k;
            int endIndex = i + k;

            if (startIndex < 0 || endIndex >= averages.length) {
                averages[i] = -1;
                continue;
            }
            if (onlyOne) {
                averages[i] = nums[i];
                continue;
            }

            long sum = sums[endIndex];
            sum -= sums[startIndex];
            sum += nums[startIndex];

            int avg = (int) sum / windowSize;
            averages[i] = avg;
        }
        return averages;
    }
}
