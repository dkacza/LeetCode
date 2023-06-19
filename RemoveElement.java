import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int[] processedArray = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            processedArray[result] = nums[i];
            result++;
        }

        nums = processedArray;

        return result;
    }
}
