import java.util.*;

/*
 * Longest Substring
 *
 * Given: String
 * Task: Find the longest sequence of unique characters
 * */
public class LongestSubstring {
    private static String input = "";

    public static void main(String[] args) {
        System.out.println("Longest substring amount in [" + input + "] - " + longestSubstring(input));
    }

    private static int longestSubstring(String s) {
        Set<String> stringSet = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        if (s.length() <= 1) {
            return s.length();
        }
        for (int i = 0; i < s.split("").length; i++) {
            String str = s.split("")[i];
            if (!builder.toString().contains(str)) {
                builder.append(str);
                stringSet.add(builder.toString());
                continue;
            }
            builder = new StringBuilder();
            i--;
        }
        return stringSet.stream().max(Comparator.comparingInt(String::length)).get().length();
    }
}
