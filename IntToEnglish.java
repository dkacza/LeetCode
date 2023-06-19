import java.util.*;

public class IntToEnglish {
    public static Map<Integer, String> names = new LinkedHashMap<>();
    static {
        names.put(1000000000, "Billion");
        names.put(1000000, "Million");
        names.put(1000, "Thousand");
        names.put(100, "Hundred");
        names.put(90, "Ninety");
        names.put(80, "Eighty");
        names.put(70, "Seventy");
        names.put(60, "Sixty");
        names.put(50, "Fifty");
        names.put(40, "Forty");
        names.put(30, "Thirty");
        names.put(20, "Twenty");
        names.put(19, "Nineteen");
        names.put(18, "Eighteen");
        names.put(17, "Seventeen");
        names.put(16, "Sixteen");
        names.put(15, "Fifteen");
        names.put(14, "Fourteen");
        names.put(13, "Thirteen");
        names.put(12, "Twelve");
        names.put(11, "Eleven");
        names.put(10, "Ten");
        names.put(9, "Nine");
        names.put(8, "Eight");
        names.put(7, "Seven");
        names.put(6, "Six");
        names.put(5, "Five");
        names.put(4, "Four");
        names.put(3, "Three");
        names.put(2, "Two");
        names.put(1, "One");
        names.put(0, "");
    }

    public static String numberToWords(int number) {
        if (number == 0) return "Zero";

        // Split into groups of three;
        Stack<Integer> groups = new Stack<>();
        Stack<Integer> groupsType = new Stack();
        int currentType = 0;
        while (number > 0) {
            int group = number % 1000;
            groups.push(group);
            number /= 1000;

            groupsType.push(currentType);
            if (currentType == 0) currentType = 1;
            currentType *= 1000;
        }

        StringBuilder result = new StringBuilder();
        // Process Each Group:
        while (!groups.empty()) {
            int currentGroup = groups.pop();
            int multiplier = groupsType.pop();

            String groupStr = convertGroup(currentGroup) + " " + names.get(multiplier) + " ";
            result.append(groupStr);
        }
        return trimRight(result.toString(), ' ');
    }
    public static String convertGroup(int number) {
        if (number == 0) return "";
        StringBuilder strNumber = new StringBuilder();

        // Hundreds
        int hundreds = number / 100;
        if (hundreds > 0) {
            strNumber.append(names.get(hundreds)).append(" ");
            strNumber.append(names.get(100)).append(" ");
        }
        number -= hundreds * 100;


        // 0 - 99
        for (int val : names.keySet()) {
            if (val <= number) {
                strNumber.append(names.get(val)).append(" ");
                number -= val;
            }
            if (number == 0) break;
        }
        return trimRight(strNumber.toString(), ' ');
    }
    public static String trimRight(String str, char charToTrim) {
        int endIndex = str.length() - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == charToTrim) {
                endIndex--;
            } else {
                break;
            }
        }
        return str.substring(0, endIndex + 1);
    }

    public static void main(String[] args) {
        String result = numberToWords(1000010);
        System.out.println(result);
    }
}
