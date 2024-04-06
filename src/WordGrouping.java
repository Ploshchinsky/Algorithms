import java.util.*;
/*
*
* Word Grouping
*
* Given: Array of strings with words
* Task: Sort the array into groups in which all words are relative anagrams
* (consist of the same letters, but in different sequence).
*
* */

public class WordGrouping {
    private static String[] example = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public static void main(String[] args) {
        System.out.println(wordGrouping(example));
    }

    public static String wordGrouping(String[] strings) {
        Map<String, String> dictionary = getDictionaryFromStrings(strings);
        StringBuilder result = new StringBuilder();
        Iterator<String> iterator = dictionary.values().iterator();

        while (iterator.hasNext()) {
            result.append("[").append(iterator.next()).append("]");
            if (iterator.hasNext()) {
                result.append(" , ");
            }
        }
        return result.toString();
    }

    private static Map<String, String> getDictionaryFromStrings(String[] strings) {
        Map<String, String> dictionary = new HashMap<>();
        for (String s : strings) {
            String key = wordSort(s);
            if (!dictionary.containsKey(key)) {
                dictionary.put(key, s);
                continue;
            }
            String value = dictionary.get(key).concat(" , " + s);
            dictionary.put(key, value);
        }
        return dictionary;
    }

    private static String wordSort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
