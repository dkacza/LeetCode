import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        SortedSet<Integer> uniqueNumbers = new TreeSet<>();
        for (int num : nums) uniqueNumbers.add(num);

        Integer[] uniqueArr = (Integer[]) uniqueNumbers.toArray();
        System.out.println(Arrays.toString(uniqueArr));
        return uniqueNumbers.size();
    }
}
