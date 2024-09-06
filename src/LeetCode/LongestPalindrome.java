package LeetCode;

public class LongestPalindrome {
    private static int maxLength = 0;
    private static int beginIndex = 0;

    public static void main(String[] args) {
        String test = "cbbd";
        String test2 = "0--=1xCx20002xCx1sj8716";

        System.out.println(longestPalindrome(test));
        resetParams();
        System.out.println(longestPalindrome(test2));
    }

    private static void resetParams() {
        maxLength = 0;
        beginIndex = 0;
    }

    private static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return s.substring(beginIndex, beginIndex + maxLength);
    }

    private static boolean findPalindrome(String str, int left, int right) {
        int currentLength = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                beginIndex = left;
            }
            left--;
            right++;
        }
        return currentLength == str.length();
    }

}
