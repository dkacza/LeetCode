import java.util.Arrays;
import java.util.OptionalInt;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int result = 0;

        int maxLevel = height[0];
        for (int level : height) {
            if (level > maxLevel) maxLevel = level;
        }

        int currentLevel = 0;
        while (currentLevel <= maxLevel) {
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] != currentLevel) continue;
                // Check for the first left boundary
                int leftBoundary = i - 1;
                while (leftBoundary > 0) {
                    if (height[leftBoundary] > currentLevel) break;
                    leftBoundary--;
                }
                // Check for the first right boundary
                int rightBoundary = i + 1;
                while (rightBoundary < height.length) {
                    if (height[rightBoundary] > currentLevel) break;
                    rightBoundary++;
                }

                if ((rightBoundary >= height.length || leftBoundary < 0) || height[leftBoundary] <= currentLevel || height[rightBoundary] <= currentLevel) continue;

                for (int j = leftBoundary + 1; j < rightBoundary; j++) {
                    height[j]++;
                    result++;
                }

            }
            currentLevel++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println(result);
    }
}
