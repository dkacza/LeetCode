import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    static HashMap<Character, Character> parenthesis = new HashMap<>();
    static {
        parenthesis.put('{', '}');
        parenthesis.put('[', ']');
        parenthesis.put('(', ')');
    }
    public static boolean isValid(String s) {
        Stack<Character> openedParenthesis = new Stack<>();
        char[] str = s.toCharArray();
        for (char sign : str) {
            if (parenthesis.containsKey(sign)) {
                openedParenthesis.push(sign);
                continue;
            }
            // Check if it is a closing parenthesis
            char currentlyOpened = openedParenthesis.pop();
            char predictedClosing = parenthesis.get(currentlyOpened);
            if (predictedClosing != sign) return false;


        }
        return openedParenthesis.isEmpty();
    }

    public static void main(String[] args) {
        String validationStr = "({{[()]}})";
        boolean result = isValid(validationStr);
        System.out.println(result);
    }
}
