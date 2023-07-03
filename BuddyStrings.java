import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> gMap = new HashMap<>();

        boolean allOneOccur = true;
        for (char letterS : s.toCharArray()) {
            if (sMap.get(letterS) == null) {
                sMap.put(letterS, 1);
                continue;
            }
            int currentVal = sMap.get(letterS);
            sMap.put(letterS, currentVal + 1);
            allOneOccur = false;
        }
        for (char letterG : goal.toCharArray()) {
            if (gMap.get(letterG) == null) {
                gMap.put(letterG, 1);
                continue;
            }
            int currentVal = gMap.get(letterG);
            gMap.put(letterG, currentVal + 1);
        }
        if (!sMap.equals(gMap)) return false;
        if (allOneOccur && s.equals(goal)) return false;

        int delta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) delta++;
        }
        if (delta == 0 && !allOneOccur) return true;
        if (delta == 2) return true;
        return false;


    }
    public static void main(String[] args) {
        String a = "ab";
        String b = "ba";
        BuddyStrings solution = new BuddyStrings();
        solution.buddyStrings(a, b);
    }
}
