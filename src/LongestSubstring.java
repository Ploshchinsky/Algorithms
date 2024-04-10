import java.util.*;

/*
 * Longest Substring
 *
 * Given: String
 * Task: Find the longest sequence of unique characters
 * */
public class LongestSubstring {
    private static String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ ";

    public static void main(String[] args) {
        System.out.println("Longest substring amount in [" + input + "] - " + longestSubstringMap(input));
        System.out.println("Longest substring amount " + longestSubstring2(input));
    }

    private static int longestSubstringMap(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<String> stringSet = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.split("").length; i++) {
            String str = s.split("")[i];
            if (!builder.toString().contains(str)) {
                builder.append(str);
                stringSet.add(builder.toString());
                continue;
            }
            builder = new StringBuilder();
            do {
                i--;
            } while (!str.equals(s.split("")[i]));
        }
        return stringSet.stream().max(Comparator.comparingInt(String::length)).get().length();
    }

    private static int longestSubstring2(String s) {
        int maxLength = 0, currentLength = 0;
        String temp;
        if (s.length() <= 1) {
            return s.length();
        }
        for (int left = 0, right = 1; right < s.length(); right++) {
            String currentChar = s.split("")[right];
            if (s.substring(left, right).contains(currentChar)) {
                left = right;
            }
            currentLength = right - left + 1;
            maxLength = currentLength > maxLength ? currentLength : maxLength;
        }

        return maxLength;
    }
}
