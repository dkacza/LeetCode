import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int rotation = k % nums.length;
        int[] end = Arrays.copyOfRange(nums,nums.length - rotation ,nums.length);
        int[] rest = Arrays.copyOfRange(nums, 0, nums.length - rotation);

        for (int i = 0; i < nums.length; i++) {
            if (i < end.length) nums[i] = end[i];
            else {
                nums[i] = rest[i - end.length];
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
