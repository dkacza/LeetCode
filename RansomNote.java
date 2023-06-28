import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> availableChars = new HashMap<>();

        char[] charsIn = magazine.toCharArray();
        for (char charIn : charsIn) {
            if (!availableChars.containsKey(charIn)) {
                availableChars.putIfAbsent(charIn, 1);
                continue;
            }
            int nextVal = availableChars.get(charIn) + 1;
            availableChars.put(charIn, nextVal);
        }

        char[] charsOut = ransomNote.toCharArray();
        for (char charOut : charsOut) {
            if (!availableChars.containsKey(charOut)) return false;
            int nextVal = availableChars.get(charOut) - 1;
            if (nextVal == -1) return false;
            availableChars.put(charOut, nextVal);
        }
        return true;
    }
}
