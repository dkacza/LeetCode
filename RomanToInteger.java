import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<String, Integer> romanValues = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        char[] sArr = s.toCharArray();
        int result = 0;
        String previousSubs = "";
        String subsequence = "";
        for (int i = 0; i < sArr.length; i++) {
            subsequence = previousSubs + sArr[i];
            if (romanValues.get(subsequence) == null) {
                int toAdd = romanValues.get(previousSubs);
                result += toAdd;
                previousSubs = String.valueOf(sArr[i]);
                continue;
            }
            previousSubs += String.valueOf(sArr[i]);
        }

        result += romanValues.get(previousSubs);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
