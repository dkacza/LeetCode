import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int windowSum = 0;

        int minLen = Integer.MAX_VALUE;

        while (right < n) {
            windowSum += nums[right];
            while (windowSum >= target) {
                windowSum -= nums[left];
                left++;
                minLen = Math.min(right - left + 2, minLen);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        solution.minSubArrayLen(target, nums);
    }
}
