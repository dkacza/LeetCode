import java.util.Arrays;

public class TimeToInform {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int processed = 1;
        int[] managers = Arrays.copyOf(manager, n);
        int[] totalTimes = new int[n];

        // 0. Prepare totalTimes array
        for (int i = 0; i < n; i++) {
            if (managers[i] == -1) {
                totalTimes[i] = 0;
                continue;
            }
            totalTimes[i] = informTime[managers[i]];
        }

        while (processed < n) {
            for (int i = 0; i < n; i++) {
                // 1. Determine who is the new boss. Increment processed if on the top (-1).
                if (managers[i] == -1) continue;
                managers[i] = manager[managers[i]];
                if (managers[i] == -1) {
                    processed++;
                    continue;
                }
                // 2. Add the time according to the new boss
                totalTimes[i] += informTime[managers[i]];
            }
        }
        return Arrays.stream(totalTimes).max().getAsInt();
    }

    public static void main(String[] args) {
        int n = 9;
        int headID = 2;
        int[] manger = new int[] {2, 2, -1, 0, 0, 0, 1, 1, 4};
        int[] informTime = new int[] {3, 2, 5, 0, 7, 0, 0, 0, 0};

        int result = numOfMinutes(n, headID, manger, informTime);
        System.out.println(result);
    }
}
