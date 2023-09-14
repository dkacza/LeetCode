public class RearangeElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        if (nums.length < 2) return nums;
        int[] result = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[positiveIndex] = nums[i];
                positiveIndex += 2;
            } else {
                result[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }
        return result;
    }
}
