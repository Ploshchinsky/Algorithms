package LeetCode;

public class LongestSubstring {
    public static void main(String[] args) {
        String t1 = "abcddcbaf";
        System.out.println(longestSubstring(t1));
    }

    private static String longestSubstring(String input) {
        int l = 0;
        String result = "";
        String current = "";
        char nextChar;

        for (int r = 1; r < input.length(); r++) {
            current = input.substring(l, r);
            nextChar = input.charAt(r);

            result = replaceStringIfCurrentLongest(current, result);

            while (current.contains(String.valueOf(nextChar))) {
                l++;
                current = input.substring(l, r);
            }
            current = current.concat(String.valueOf(nextChar));
            result = replaceStringIfCurrentLongest(current, result);
        }
        return result;
    }

    private static String replaceStringIfCurrentLongest(String current, String result) {
        if (current.length() > result.length()) {
            result = current;
        }
        return result;
    }
}
