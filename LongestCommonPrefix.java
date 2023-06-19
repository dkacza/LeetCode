import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // Loop through the first word and find whether the next word begin with the substring from the first one
        int endIndex;
        for (int i = 0; i <= strs[0].length(); i++) {
            String subStr = strs[0].substring(0, i);

            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(subStr) || subStr.length() > strs[j].length()) {
                    return strs[0].substring(0, i - 1);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strArr = new String[] {"ab", "a"};
        System.out.println(longestCommonPrefix(strArr));
    }
}
