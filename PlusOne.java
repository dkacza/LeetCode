import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean overflow = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
            if (i == 0) overflow = true;
        }
        if (overflow) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < result.length - 1; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;
    }
}
