public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int wordLength = s.length();
        int curMaxLen = 0;
        String curMaxPalindrome = "";
        for (int centerIndex = 0; centerIndex < wordLength; centerIndex++ ) {
            for (int palindromeRadius = 0; palindromeRadius < wordLength / 2; palindromeRadius++) {
                int startIndex = centerIndex - palindromeRadius;
                int endIndex = centerIndex + palindromeRadius + 1;
                if (startIndex < 0 || endIndex > wordLength) break;
                String substr = s.substring(startIndex, endIndex);
                if (checkPalindrome(substr)) {
                    if (substr.length() > curMaxLen) {
                        curMaxLen = substr.length();
                        curMaxPalindrome = substr;
                    }
                    continue;
                }
                break;
            }
        }
        return curMaxPalindrome;
    }
    private boolean checkPalindrome(String word) {
        char[] letters = word.toCharArray();
        int length = letters.length;

        for (int i = 0; i < length / 2; i++) {
            if (letters[i] != letters[length - i - 1]) return false;
        }
        return true;
    }
}
