public class SquareRoot {
    public int mySqrt(int x) {
        int precision = 50;
        double a = x;
        double b = 1;

        for (int i = 0; i < precision; i++) {
            a = (a + b) / 2;
            b = x / a;
        }

        return (int) a;
    }
}
