public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;
        while (left < right) {
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        new ContainerWithMostWater().maxArea(height);
    }
}
