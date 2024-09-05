package LeetCode;

public class LongestPalindrome {
    private static int maxLength = 0;
    private static int beginIndex = 0;

    public static void main(String[] args) {
        String test = "1xxCCxx1";
        String test2 = "0--=1xCx20002xCx1sj8716";

        System.out.println(longestPalindrome(test));
        resetParams();
        System.out.println(longestPalindrome(test2));
    }

    private static void resetParams() {
        maxLength = 0;
        beginIndex = 0;
    }

    private static String longestPalindrome(String input) {
        if (input.length() <= 1) {
            return input;
        }

        for (int i = 0; i < input.length(); i++) {
            findPalindrome(input, i, i);
            findPalindrome(input, i, i + 1);
        }
        return input.substring(beginIndex, beginIndex + maxLength);
    }

    private static boolean findPalindrome(String s, int left, int right) {
        int currentLength = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                beginIndex = left;
            }
            left--;
            right++;
        }
        return currentLength == s.length();
    }

}
