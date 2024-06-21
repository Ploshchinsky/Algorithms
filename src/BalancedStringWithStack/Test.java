package BalancedStringWithStack;

import java.util.Stack;

/*
 * Balanced String
 * Given: a text string containing parentheses.
 * Task: to determine whether the string is balanced (all opening brackets are closed).
 * */
public class Test {
    public static void main(String[] args) {
        String text1 = "This text string is used to verify that the " +
                "Balanced String definition method is working correctly";
        String text2 = "This text string is used to verify (that the " +
                "(Balanced String) definition method) is working correctly";
        String text3 = "This text string is (used to verify) that the " +
                "Balanced String definition method is working correctly)";
        String text4 = "(This text string is (used to verify) that the " +
                "Balanced String definition method is working correctly)(";
        String text5 = "{) (  ) (}";
        String text6 = "( (  ) (   )   ( )   )";

        System.out.println(isBalancedString(text1));
        System.out.println(isBalancedString(text2));
        System.out.println(isBalancedString(text3));
        System.out.println(isBalancedString(text4));
        System.out.println(isBalancedString(text5));
        System.out.println(isBalancedString(text6));
    }

    private static boolean isBalancedString(String text1) {
        Stack<Character> braces = new Stack<>();
        for (char c : text1.toCharArray()) {
            switch (c) {
                case '(', '{', '[', '<':
                    braces.push(c);
                    break;
                case ')':
                    if (braces.empty() || braces.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (braces.empty() || braces.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (braces.empty() || braces.pop() != '[') {
                        return false;
                    }
                    break;
                case '>':
                    if (braces.empty() || braces.pop() != '<') {
                        return false;
                    }
                    break;
            }
        }
        return braces.empty();
    }
}
