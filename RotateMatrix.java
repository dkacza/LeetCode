import java.util.Arrays;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        rotateRing(matrix, 0);
    }
    public static void rotateSquare(int[][] matrix, int startIndex) {
        int tmp = matrix[startIndex][startIndex]; // STORE UPPER LEFT
        matrix[startIndex][startIndex] = matrix[startIndex + 1][startIndex]; // TRANSFER BOTTOM LEFT TO UPPER LEFT

        int tmp2 = matrix[startIndex][startIndex + 1]; // STORE UPPER RIGHT
        matrix[startIndex][startIndex + 1] = tmp; // TRANSFER UPPER LEFT TO UPPER RIGHT

        int tmp3 = matrix[startIndex + 1][startIndex + 1]; // STORE BOTTOM RIGHT
        matrix[startIndex + 1][startIndex + 1] = tmp2; // TRANSFER UPPER RIGHT TO BOTTOM RIGHT

        matrix[startIndex + 1][startIndex] = tmp3; // TRANSFER BOTTOM RIGHT TO BOTTOM LEFT
    }
    public static void rotateRing(int[][] matrix, int startIndex) {
        int size = matrix.length;
        if ((startIndex) * 2 == size - 1) return;
        if ((startIndex) * 2 == size - 2) {
            rotateSquare(matrix, startIndex);
            return;
        }

        int ringSize = matrix.length - (startIndex * 2);
        int endIndex = startIndex + ringSize - 1;

        for (int i = 0; i < ringSize - 1; i++) {
            // LEFT TO TOP
            // TOP TO RIGHT
            // RIGHT TO BOTTOM
            // BOTTOM TO LEFT

            int firstTop = matrix[startIndex][startIndex + i];
            int firstRight = matrix[startIndex + i][endIndex];
            int firstBottom = matrix[endIndex][endIndex - i];
            int firstLeft = matrix[endIndex - i][startIndex];

            matrix[startIndex + i][endIndex] = firstTop;
            matrix[endIndex][endIndex - i] = firstRight;
            matrix[endIndex - i][startIndex] = firstBottom;
            matrix[startIndex][startIndex + i] = firstLeft;

        }
        rotateRing(matrix, startIndex + 1);
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        RotateMatrix solution = new RotateMatrix();
        solution.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
