import java.util.HashMap;
import java.util.Map;

/*
 * Run-length encoding (RLE)
 * or repetition coding is a data compression algorithm that replaces repetitive
 * characters (series) with a single character.
 * */
public class RLE {
    public static void main(String[] args) {
        String test = "AAAABBCDDDDDEE";

        //Single Pass based algorithm
        System.out.println(RLE(test));
        //Map based algorithm
        System.out.println(RLEMap(test));
    }

    public static String RLE(String string) {
        StringBuilder builder = new StringBuilder();
        char[] chars = string.toCharArray();

        char currentChar = chars[0];
        int currentSize = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                currentSize++;
                if (i == chars.length - 1) {
                    builder.append(currentChar).append(currentSize > 1 ? currentSize : "");
                }
            } else {
                builder.append(currentChar).append(currentSize > 1 ? currentSize : "");
                currentSize = 1;
                currentChar = chars[i];

            }
        }
        return builder.toString();
    }

    public static String RLEMap(String string) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> charsMap = new HashMap<>();
        char[] chars = string.toCharArray();

        charsMap.put(chars[0], 1);

        for (int i = 1; i < chars.length; i++) {
            if (!charsMap.containsKey(chars[i])) {
                res.append(chars[i - 1]).append(charsMap.get(chars[i - 1]) > 1 ? charsMap.get(chars[i - 1]) : "");
                charsMap.put(chars[i], 1);
            } else {
                charsMap.put(chars[i], charsMap.get(chars[i]) + 1);
                if (i == chars.length - 1) {
                    res.append(chars[i]).append(charsMap.get(chars[i]) > 1 ? charsMap.get(chars[i]) : "");
                }
            }
        }

        return res.toString();
    }

}
