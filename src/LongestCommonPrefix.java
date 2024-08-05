import java.util.*;

public class LongestCommonPrefix {
    public static String[] strings1 = {"flower", "flow", "flight"};
    public static String[] strings2 = {"dog", "racecar", "car"};

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(strings1));
        System.out.println(longestCommonPrefix(strings2));
    }

    private static String longestCommonPrefix(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        String min = Arrays.stream(strs).min(Comparator.comparing(String::length)).get();

        for (int i = 1; i <= min.length(); i++) {
            map.put(min.substring(0, i), 0);
        }


        for (String s : strs) {
            for (String prefix : map.keySet()) {
                if (s.startsWith(prefix)) {
                    map.put(prefix, map.get(prefix) + 1);
                }
            }
        }


        return map.entrySet().stream()
                .filter(entry -> entry.getValue() >= strs.length)
                .max(Comparator.comparingInt(o -> o.getKey().length()))
                .orElse(Map.entry("", 0)).getKey();
    }
}
