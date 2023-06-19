public class MinFlip {
    public static int minFlips(int a, int b, int c) {
        // Convert to binary
        String aBin = Integer.toBinaryString(a);
        String bBin = Integer.toBinaryString(b);
        String cBin = Integer.toBinaryString(c);

        // Pad the strings
        int maxLength = Math.max(aBin.length(), bBin.length());
        maxLength = Math.max(maxLength, cBin.length());
        aBin = padLeft(aBin, maxLength, '0');
        bBin = padLeft(bBin, maxLength, '0');
        cBin = padLeft(cBin, maxLength, '0');

        int flips = 0;
        // Iterate through
        for (int i = 0; i < maxLength; i++) {
            String values = new String(new char[]{aBin.charAt(i), bBin.charAt(i), cBin.charAt(i)});
            switch (values) {
                case "000", "011", "101", "111" -> flips += 0;
                case "001", "010", "100" -> flips += 1;
                case "110" -> flips += 2;
            }
        }
        return flips;
    }
    public static String padLeft(String original, int desiredLength, char sign) {
        int charsToFill = desiredLength - original.length();

        return String.valueOf(sign).repeat(Math.max(0, charsToFill)) +
                original;
    }
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 7;

        int result = minFlips(4, 2, 7);
        System.out.println(result);
    }
}
