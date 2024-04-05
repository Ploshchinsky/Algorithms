import java.util.*;

/*
 *
 * Check Dictionary
 *
 * */
public class CheckDictionary {
    public static List<String> wordsList;
    public static List<String> extendedWordsList;
    public static final int MAX_LEN = 5;

    public static void main(String[] args) {
        wordsList = wordsMapGenerator();
        String text = "This text is intended to test the function" +
                " of finding words that may contain a single character omission error wrds fnction";

        extendedWordsList = new ArrayList<>();
        for (String s : wordsList) {
            String[] temp = misspellWord(s);
            extendedWordsList.add(s);
            extendedWordsList.addAll(Arrays.asList(temp));
        }

        int matchValue = matchCounter(text);
        System.out.printf(matchValue > 0 ? "Matches found " +matchValue + " times" : "No matches");

    }

    public static String[] misspellWord(String word) {
        if (word.length() < 2) {
            return word.split("");
        }
        String[] result = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char[] temp = word.toCharArray();
            temp[i] = ' ';
            result[i] = String.valueOf(temp).replaceAll(" ", "");
        }
        return result;
    }

    public static List<String> wordsMapGenerator() {
        List<String> stringList = new ArrayList<>();
        String input = "This is a list of words for the source " +
                "dictionary with which each word of the given text will be compared function";
        Arrays.stream(input.split(" ")).forEach(stringList::add);
        return stringList;
    }

    public static int matchCounter(String text) {
        int matchCounter = 0;
        for (String s : text.split(" ")) {
            matchCounter += extendedWordsList.contains(s) ? 1 : 0;
        }
        return matchCounter;
    }
}
