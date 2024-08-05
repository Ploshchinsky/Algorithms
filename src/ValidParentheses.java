import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
    static String s1 = "()[]{}";
    static String s2 = "([)]";
    static String s3 = "(]";

    public static void main(String[] args) {
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{', '<':
                    deque.add(c);
                    break;
                case ')':
                    if (deque.isEmpty() || !deque.removeLast().equals('('))
                        return false;
                    break;
                case ']':
                    if (deque.isEmpty() || !deque.removeLast().equals('['))
                        return false;
                    break;
                case '}':
                    if (deque.isEmpty() || !deque.removeLast().equals('{'))
                        return false;
                    break;
                case '>':
                    if (deque.isEmpty() || !deque.removeLast().equals('<'))
                        return false;
                    break;
            }
        }
        return deque.isEmpty();
    }
}
