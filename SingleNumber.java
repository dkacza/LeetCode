import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int n : nums) {
            if (occurrences.get(n) == null) {
                occurrences.put(n, 1);
                continue;
            }
            int currentOccurrences = occurrences.get(n);
            occurrences.put(n, currentOccurrences + 1);
        }
        for (int key : occurrences.keySet()) {
            if (occurrences.get(key) == 1) return key;
        }
        return 0;
    }
}
