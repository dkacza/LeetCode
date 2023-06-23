// Problem 1027 - Medium
// Longest Arithmetic Subsequence
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static int longestArithSeqLength(int[] nums) {
        ArrayList<Map<Integer, Integer>> sequences = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sequences.add(new HashMap<>());
        }
        int maxLength = 2;
        for (int right = 1; right < nums.length; right++) {
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                if (sequences.get(left).get(diff) != null) {
                    int diffLength = sequences.get(left).get(diff);
                    int newLength = diffLength + 1;
                    sequences.get(right).put(diff, newLength);
                    if (newLength > maxLength) maxLength = newLength;
                    continue;
                }
                sequences.get(right).putIfAbsent(diff, 2);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {20, 1, 15, 3, 10, 5, 8};
        longestArithSeqLength(numbers);
    }
}

