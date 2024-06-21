package Stack.StringReverse;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String text0 = "Simple";
        String text1 = "This text string is used to verify that the" +
                "Balanced String definition method is working correctly";
        System.out.println(stringReverse(text0));
        System.out.println(stringReverse(text1));
    }

    private static String stringReverse(String text) {
        StringBuilder result = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();
        for (Character c : text.toCharArray()) {
            characterStack.push(c);
        }
        while (!characterStack.empty()) {
            result.append(characterStack.pop());
        }
        return result.toString();
    }
}
