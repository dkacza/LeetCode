import java.util.ArrayList;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder word = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        result.append(convertInitial(word, numRows));
        convertAfterInitial(word, result, numRows - 1);
        return result.toString();
    }

    private void convertAfterInitial(StringBuilder word, StringBuilder result, int numRows) {
        if (numRows == 1) {
            result.append(word.toString());
            return;
        }
        int offset = (numRows * 2) - 1;
        int i = 0;
        ArrayList<Integer> indexesToDelete = new ArrayList<>();
        while (i < word.length()) {
            result.append(word.charAt(i));
            word.setCharAt(i, '-');
            indexesToDelete.add(i);

            if (i + offset > word.length()) break;

            result.append(word.charAt(i + offset - 1));
            word.setCharAt(i + offset - 1, '-');
            indexesToDelete.add(i + offset - 1);

            i += offset;
        }
        deleteAtIndexes(word, indexesToDelete);
        convertAfterInitial(word, result, numRows - 1);
    }
    private static void deleteAtIndexes(StringBuilder word, ArrayList<Integer> indexes) {
        int deleted = 0;
        for (int i : indexes) {
            word.deleteCharAt(i - deleted);
            deleted++;
        }
    }
    private static String convertInitial(StringBuilder word, int numRows) {
        int offset = (numRows * 2) - 2;
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> indexesToDelete = new ArrayList<>();
        for (int i = 0; i < word.length(); i += offset) {
            result.append(word.charAt(i));
            word.setCharAt(i, '-');
            indexesToDelete.add(i);
        }
        deleteAtIndexes(word, indexesToDelete);
        return result.toString();
    }
    public static void main(String[] args) {
        String toConvert = "PAYPALISHIRING";
        ZigzagConversion solution = new ZigzagConversion();
        solution.convert(toConvert, 4);
    }
}
