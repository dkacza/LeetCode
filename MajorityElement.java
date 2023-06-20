import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            if (occurrences.get(num) == null) {
                occurrences.put(num, 1);
                continue;
            }
            occurrences.put(num, occurrences.get(num) + 1);
        }
        int maxOccurrences = 0;
        int result = 0;
        for (int number : occurrences.keySet()) {
            if (occurrences.get(number) > maxOccurrences) {
                result = number;
                maxOccurrences = occurrences.get(number);
            }
        }
        return result;
    }
}
