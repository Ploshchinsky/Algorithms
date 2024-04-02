import java.util.*;

public class CharCounter {
    public static void main(String[] args) {
        String input = "Test string ee tt ggg sssstttt";
        System.out.println("[new] Maximum entry symbol - " + " '" + charCounter(input) + "' ");
        System.out.println("[old] Maximum entry symbol - " + " '" + charCounterOld(input) + "' ");
        System.out.println("[old+optimized] Maximum entry symbol - " + " '" + charCounterOldOpti(input) + "' ");
    }

    public static char charCounter(String string) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            charMap.put
                    (string.charAt(i),
                            charMap.get(string.charAt(i)) == null ? 1 : charMap.get(string.charAt(i)) + 1);
        }

        int max = 0;
        char res = ' ';

        for (Character c : charMap.keySet()) {
            if (charMap.get(c) > max) {
                max = charMap.get(c);
                res = c;
            }
        }
        return res;
    }

    public static char charCounterOld(String string) {
        char result = ' ';
        int max = 0;
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            int counter = 0;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == temp) {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
                result = temp;
            }
        }
        return result;
    }

    public static char charCounterOldOpti(String string) {
        Set<Character> charSet = new HashSet<>();
        string.chars().forEach(value -> charSet.add((char) value));

        char res = ' ';
        int max = 0;

        for (Character c : charSet) {
            int counter = 0;
            for (Character c2 : string.toCharArray()) {
                if (c == c2) {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
                res = c;
            }
        }
        return res;
    }
}
