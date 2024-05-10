/*
*
* WordsCounter
* A method that counts the number of occurrences of words in the text
* (excluding special characters)
*
* */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
    public static void main(String[] args) {
        String text = "A simple text to test the functionality " +
                "of a method that counts the number of " +
                "occurrences of words, in a text";

        Map<String, Integer> counterMap = wordsCount(text);
        System.out.println(counterMap);
    }

    private static Map<String, Integer> wordsCount(String text) {
        String[] words = text.replaceAll("[^a-zA-Z]", " ").split(" ");
        Map<String, Integer> counterMap = new HashMap<>();

        Arrays.stream(words).forEach(word -> {
            counterMap.put(word.toLowerCase(), counterMap.getOrDefault(word.toLowerCase(), 0) + 1);
        });
        return counterMap;
    }
}
