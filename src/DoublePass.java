import java.util.*;
/*
Double Pass Algorithms
    1. allShortsWords() - This method finds the shortest words and outputs them in string

*/

public class DoublePass {
    public static void main(String[] args) {
        String testString1 = "This method finds the shortest words and outputs them int string";
        System.out.println(allShortsWords(testString1));
    }

    public static String allShortsWords(String string) {
        StringBuilder res = new StringBuilder();
        String[] words = string.split(" ");

        int currentMin = words[0].length();
        res.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < currentMin) {
                currentMin = words[i].length();
                res = new StringBuilder();
                res.append(words[i]);
            } else if (words[i].length() == currentMin) {
                res.append(" ").append(words[i]);
            }
        }
        return res.toString();
    }
}
