import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
        ArrayList<String> codes = new ArrayList<>();
        codes.add("0");
        codes.add("1");
        for (int i = 1; i < n; i++) {
            // mirror
            // add 0 or 1 upfront
            for (int j = codes.size() - 1; j >= 0; j--) {
                String newEntry = "1" + codes.get(j);
                codes.add(newEntry);
                codes.set(j, "0" + codes.get(j));
            }
        }
        List<Integer> result = new LinkedList<>();
        for (String binNumber : codes) {
            result.add(Integer.parseInt(binNumber, 2));
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        grayCode(n);
    }
}
