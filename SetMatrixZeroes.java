import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> coordinatesToSwap = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) coordinatesToSwap.add(new int[]{i, j});
            }
        }

        for (int[] crd : coordinatesToSwap) {
            Arrays.fill(matrix[crd[0]], 0);
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][crd[1]] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
    }
}
