public class FirstIndexOfOccurence {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            String substr = haystack.substring(i, i + needleLength);
            if (needle.equals(substr)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FirstIndexOfOccurence solution = new FirstIndexOfOccurence();
        solution.strStr("hello", "ll");
    }
}
