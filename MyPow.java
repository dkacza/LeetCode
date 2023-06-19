public class MyPow {
    public static double myPow(double x, int n) {
        double base = x;
        if (n == 0 || x == 1) return 1.0;
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (x == 0) return 0.0;
        if (n < 0) base = 1 / x;
        long iterations = (long) n > 0 ? (long )n : (long) -1 * n;
        double result = 1;
        for (int i = 0; i < iterations; i++) {
            result *= base;
            if (Math.abs(result) < 0.000000001) return 0.0;
        }
        return result;
    }
    public static void main(String[] args) {
        double x = 2.0;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }
}
