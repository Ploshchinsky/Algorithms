import java.util.*;

/*
 * Longest Substring
 *
 * Given: String
 * Task: Find the longest sequence of unique characters
 * */
public class LongestSubstring {
    private static String input =
            "abcabcabcabbbsjtoasldldllldoogjjgititjjgjabcabcabcabbbsjtoasldldllldoogjjgititjjgj[]123[-0698-!)@$+)^*&";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.print("Longest substring amount in [" + input + "] - " + longestSubstringMap(input));
        System.out.print(System.currentTimeMillis() - start + " ms\n");
        start = System.currentTimeMillis();
        System.out.print("Longest substring amount " + longestSubstringOpt(input));
        System.out.println(System.currentTimeMillis() - start + " ms\n");
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

    private static int longestSubstringOpt(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (int left = 0, right = 0; right < s.length(); right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max((right - left + 1), maxLength);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }

        }

        return maxLength;
    }
}
