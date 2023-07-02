public class StrictlyPalindromicNumber {
    public static boolean checkPalindrome(String number) {
        char[] digits = number.toCharArray();
        for (int i = 0; i < digits.length / 2; i++) {
            if (digits[i] != digits[digits.length - 1 - i]) return false;

        }
        return true;
    }
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; base++) {
            String numberInBase = Integer.toString(n, base);
            if (!checkPalindrome(numberInBase)) return false;
        }
        return true;
    }
}
