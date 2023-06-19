import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    static Map<Integer, String> values = new HashMap<>();
    static {
        values.put(1, "I");
        values.put(4, "IV");
        values.put(5, "V");
        values.put(9, "IX");
        values.put(10, "X");
        values.put(40, "XL");
        values.put(50, "L");
        values.put(90, "XC");
        values.put(100, "C");
        values.put(400, "CD");
        values.put(500, "D");
        values.put(900, "CM");
        values.put(1000, "M");
    }
    static int[] intValues = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int tmp = num;
        while(tmp > 0) {
            // Select the largest key from keyset
            for (int i = intValues.length - 1; i >= 0; i--) {
                if (intValues[i] > tmp) continue;
                tmp -= intValues[i];
                result.append(values.get(intValues[i]));
                break;
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        int number = 1949;
        String roman = intToRoman(number);
        System.out.println(roman);
    }

}
