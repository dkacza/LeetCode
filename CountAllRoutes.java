// Problem 1575 - Hard
// Count all possible routes

import java.util.Arrays;

public class CountAllRoutes {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] memo = new int[n][fuel + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return recursiveSearch(locations, start, finish, fuel, memo);

    }

    private int recursiveSearch(int[] locations, int currentCity, int finish, int fuel, int[][] memo) {
        if (fuel < 0) return 0;
        if (memo[currentCity][fuel] != -1) return memo[currentCity][fuel];
        int result = currentCity == finish ? 1 : 0;
        for (int nextCity = 0; nextCity < locations.length; nextCity++) {
            if (nextCity != currentCity) {
                result = (result + recursiveSearch(locations, nextCity, finish, fuel - Math.abs(locations[currentCity] - locations[nextCity]), memo)) % 1000000007;
            }
        }
        return memo[currentCity][fuel] = result;
    }

    public static void main(String[] args) {
        CountAllRoutes solution = new CountAllRoutes();
        int[] locations = new int[] {2,3,6,8,4};
        int result = solution.countRoutes(locations, 1, 3, 5);
        System.out.println(result);
    }
}
