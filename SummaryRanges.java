import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if(nums.length == 0) return result;

        int previousNumber = nums[0];
        int rangeBegin = nums[0];
        int rangeEnd;
        for (int i = 1; i < nums.length; i++) {
            // If difference is not equal to 1 add range
            if (nums[i] - previousNumber == 1) {
                previousNumber = nums[i];
                continue;
            }
            rangeEnd = previousNumber;

            // Add range
            System.out.println(rangeBegin + " " + rangeEnd);
            String range = rangeEnd == rangeBegin ? String.format("%d", rangeBegin) : String.format("%d->%d", rangeBegin, rangeEnd);
            result.add(range);

            previousNumber = nums[i];
            rangeBegin = nums[i];
        }

        rangeEnd = nums[nums.length - 1];
        String range = rangeEnd == rangeBegin ? String.format("%d", rangeBegin) : String.format("%d->%d", rangeBegin, rangeEnd);
        result.add(range);

        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> ranges = summaryRanges(nums);
        for (String range : ranges) {
            System.out.println(range);
        }
    }
}
