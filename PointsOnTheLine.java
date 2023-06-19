public class PointsOnTheLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];


        if (deltaX == 0) {
            // check for straight line
            for (int[] coordinate : coordinates) {
                if (coordinate[0] != x0) return false;
            }
            return true;
        }
        if (deltaY == 0) {
            // check for straight line
            for (int[] coordinate : coordinates) {
                if (coordinate[1] != y0) return false;
            }
            return true;
        }
        double a0 = (double) deltaY / deltaX;


        for (int i = 1; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            double curA = (double) (y - y0) / (x - x0);
            if (curA != a0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //int[][] crds = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] crds = {{2,1},{4,2},{6,3}};
        boolean result = checkStraightLine(crds);
        System.out.println(result);

    }
}
