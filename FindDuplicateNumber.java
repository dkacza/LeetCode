import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int number : nums) {
            if (numbers.contains(number)) return number;
            numbers.add(number);
        }
        return -1;
    }
}
