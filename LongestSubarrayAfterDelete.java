import java.util.ArrayList;

public class LongestSubarrayAfterDelete {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> subsequences = new ArrayList<>();
        int numOfZeroes = 0;
        int currentOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentOnes++;
                continue;
            }
            subsequences.add(currentOnes);
            numOfZeroes++;
            currentOnes = 0;
        }
        subsequences.add(currentOnes);

        if (currentOnes == nums.length) return nums.length - 1;

        int maxSubsequence = subsequences.get(0) + subsequences.get(1);
        for (int i = 2; i < subsequences.size(); i++) {
            int subsequenceAfterDelete = subsequences.get(i) + subsequences.get(i - 1);
            if (subsequenceAfterDelete > maxSubsequence) maxSubsequence = subsequenceAfterDelete;
        }
        return maxSubsequence;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,0,0,1,1,1,0,1};
        LongestSubarrayAfterDelete solution = new LongestSubarrayAfterDelete();
        solution.longestSubarray(nums);
    }
}
