import java.util.HashMap;

public class Palindrome {
    public static void main(String[] args) {
        String input = "testxtset";
        String input2 = "simpxsimp";
        System.out.println("input 1 - " + isPalindrome(input));
        System.out.println("input 2 - " + isPalindrome(input2));
    }

    private static boolean isPalindrome(String string) {
        String left = string.substring(0, string.length() / 2);
        StringBuilder right = new StringBuilder(string.substring(string.length() / 2 + 1, string.length()));
        return left.contentEquals(right.reverse());
    }
}
