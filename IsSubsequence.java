public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] letters = t.toCharArray();
        char[] substr = s.toCharArray();
        if (substr.length == 0) return true;

        int subIndex = 0;
        for (char letter : letters) {
            if (letter == substr[subIndex]) {
                subIndex++;
                if (subIndex == substr.length) return true;
            };
        }
        return false;
    }
}

