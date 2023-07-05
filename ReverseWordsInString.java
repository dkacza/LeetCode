public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].contains(" ") || words[i].equals("")) continue;
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
