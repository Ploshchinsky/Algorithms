/*
* Run-length encoding (RLE)
* or repetition coding is a data compression algorithm that replaces repetitive
* characters (series) with a single character.
* */
public class RLE {
    public static void main(String[] args) {
        String test = "AAAABBCDDDDDEE";
        System.out.println(RLE(test));
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
}
