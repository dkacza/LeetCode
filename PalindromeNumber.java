public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int result = 0;
        int tmp = x;
        int lastDigit;
        while (true) {
            lastDigit = tmp % 10;
            result += lastDigit;
            tmp /= 10;
            if (tmp <= 0) break;
            result *= 10;

        }

        return result == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}