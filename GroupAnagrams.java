import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            Map<Character, Integer> letters = countOccurrences(word);
            if (groups.containsKey(letters)) {
                List<String> currentList = groups.get(letters);
                currentList.add(word);
                groups.put(letters, currentList);
                continue;
            }
            List<String> newList = new LinkedList<>();
            newList.add(word);
            groups.put(letters, newList);
        }
        return new LinkedList<>(groups.values());
    }

    private static Map<Character, Integer> countOccurrences(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char letter : word.toCharArray()) {
            if (!result.containsKey(letter)) {
                result.put(letter, 1);
                continue;
            }
            result.put(letter, result.get(letter) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(words);
    }
}
