import java.util.Arrays;

public class PointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] response = new int[n];
        Arrays.fill(response, 0);
        for (int i = 0; i < n; i++) {
            int circleX = queries[i][0];
            int circleY = queries[i][1];
            int radius = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                if (radius >= calcDistance(points[j][0], points[j][1], circleX, circleY)) response[i]++;
            }
        }
        return response;
    }
    public static double calcDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
