import java.util.HashMap;
import java.util.Map;

/*
 * Run-length encoding (RLE)
 * or repetition coding is a data compression algorithm that replaces repetitive
 * characters (series) with a single character.
 * */
public class RLE {
    public static void main(String[] args) {
        String test = "AAAABBCDDDDDEEF";

        //Single Pass based algorithm
        System.out.println(RLE(test));

    }

    public static String RLE(String string) {
        StringBuilder builder = new StringBuilder();

        int l = 0;
        int r = 0;

        while (r < string.length()) {
            if (string.charAt(l) == string.charAt(r)) {
                r++;
            } else {
                builder.append(string.charAt(l)).append(r - l > 1 ? r - l : "");
                l = r;
            }
            if (r == string.length()){
                builder.append(string.charAt(l)).append(r - l > 1 ? r - l : "");
            }
        }
        return builder.toString();
    }


}
