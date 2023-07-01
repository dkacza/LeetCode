public class DeciBinaryPartition {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char digit : n.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(digit));
            if (number > maxDigit) maxDigit = number;
        }
        return maxDigit;
    }
}
