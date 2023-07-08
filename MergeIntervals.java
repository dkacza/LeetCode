import java.util.ArrayList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // SORT
        for (int i = 0; i < intervals.length; i++) {
            int min = intervals[i][0];
            int minIndex = i;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] < min) {
                    min = intervals[j][0];
                    minIndex = j;
                }
            }
            int[] tmp = intervals[i];
            intervals[i] = intervals[minIndex];
            intervals[minIndex] = tmp;
        }

        ArrayList<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == current[0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
                continue;
            }
            if (current[1] >= intervals[i][0]) {
                current[0] = Math.min(intervals[i][0], current[0]);
                current[1] = Math.max(intervals[i][1], current[1]);
                continue;
            }
            if (current[1] >= intervals[i][1] && current[0] <= intervals[i][0]) {
                continue;
            }
            merged.add(current);
            current = intervals[i];
        }
        merged.add(current);

        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        new MergeIntervals().merge(intervals);
    }
}
