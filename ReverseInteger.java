public class ReverseInteger {
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x *= -1;
            negative = true;
        }
        long reversed = 0;
        while (x > 0) {
            reversed *= 10;
            int digit = x % 10;
            reversed += (int) digit;
            x /= 10;
        }
        if (reversed > Integer.MAX_VALUE) return 0;
        int result = (int) reversed;
        if (negative) return -1 * result;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
