package Queue;

import java.util.*;

public class ParenthesesBalancing {
    public static String test1 = "(text { number { i } } text < tag >)";
    public static String test2 = "<[{(())}]>";

    public static void main(String[] args) {
        System.out.println(isParenthesesBalance(test1));
        System.out.println(isParenthesesBalance(test2));
    }

    public static boolean isParenthesesBalance(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (str.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isPair(open, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPair(char open, Character close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}') ||
                (open == '<' && close == '>');
    }
}
