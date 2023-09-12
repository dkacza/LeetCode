import java.util.Arrays;

public class MinOperationsToMoveAllBalls {
    public int[] minOperations(String boxes) {
        char[] boxesArr = boxes.toCharArray();
        int[] resultArr = new int[boxesArr.length];
        Arrays.fill(resultArr, 0);

        for (int i = 0; i < resultArr.length; i++) {
            int sumForIthPosition = 0;
            for (int j = 0; j < resultArr.length; j++) {
                if (boxesArr[j] == '1') {
                    sumForIthPosition += Math.abs(i - j);
                }
            }
            resultArr[i] = sumForIthPosition;
        }

        return resultArr;
    }
}
