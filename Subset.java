import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static String padLeft(String word, char sign, int newLength) {
        int currentLength = word.length();
        int charsToPad = newLength - currentLength;
        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = 0; i < charsToPad; i++) {
            wordBuilder.insert(0, sign);
        }
        return wordBuilder.toString();
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int numberOfPermutations = (int) Math.pow(2, n);
        List<List<Integer>> subsets = new ArrayList<>();

        for(int i = 0; i < numberOfPermutations; i++) {
            String numberBin = padLeft(Integer.toBinaryString(i), '0', n);
            List<Integer> permutation = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (numberBin.charAt(j) == '0') continue;
                permutation.add(nums[j]);
            }
            subsets.add(permutation);
        }
        return subsets;
    }

}
