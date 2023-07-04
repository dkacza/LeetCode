import java.util.Arrays;

public class WidestVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xCoordinates = new int[n];
        for (int i = 0; i < n; i++) {
            xCoordinates[i] = points[i][0];
        }
        Arrays.sort(xCoordinates);
        int previousX = xCoordinates[0];
        int maxDelta = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int delta = xCoordinates[i] - previousX;
            if (delta > maxDelta) maxDelta = delta;
            previousX = xCoordinates[i];
        }
        return maxDelta;
    }
}
