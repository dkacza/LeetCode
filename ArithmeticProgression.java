import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArithmeticProgression {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Set<Integer> numbers = new HashSet<>();

        // Find 2 smallest numbers and add all numbers to the set
        int smallest = Math.min(arr[0], arr[1]);
        int smallest2 = Math.max(arr[0], arr[1]);

        numbers.add(smallest);
        numbers.add(smallest2);
        for (int i = 2; i < arr.length; i++) {
            numbers.add(arr[i]);

            if (arr[i] < smallest) {
                smallest2 = smallest;
                smallest = arr[i];
                continue;
            }
            if (arr[i] < smallest2) {
                smallest2 = arr[i];
            }
        }

        int delta = smallest2 - smallest;

        if (delta == 0) {
            return numbers.size() == 1;
        }
        if (numbers.size() != arr.length) return false;


        int current = smallest2;
        for (int i = 2; i < numbers.size(); i++) {
            current += delta;
            if (!numbers.contains(current)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {0,5,3,4,6,9};
        boolean result = canMakeArithmeticProgression(numbers);
        System.out.println(result);
    }
}
