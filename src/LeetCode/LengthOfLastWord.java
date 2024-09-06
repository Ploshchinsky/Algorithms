package LeetCode;

//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
public class LengthOfLastWord {
    public static void main(String[] args) {
        String t1 = "Luffy is still joyboy";
        String t2 = "  fly me   to   the moon  ";
        String t3 = "      a              bb                ";
        System.out.println("---Recursive Last Index---");
        System.out.println(lengthOfLastWord(t1));
        System.out.println(lengthOfLastWord(t2));
        System.out.println(lengthOfLastWord(t3));
        System.out.println("---Split---");
        System.out.println(lengthOfLastWordSplit(t2));
        System.out.println(lengthOfLastWordSplit(t3));
    }

    //Good
    private static int lengthOfLastWord(String s) {
        int lastIndex = s.lastIndexOf(" ");
        if (lastIndex == s.length() - 1) {
            String temp = s.substring(0, (s.length() - 1));
            return lengthOfLastWord(temp);
        }
        return (s.length() - lastIndex) - 1;
    }


    //Used too many memory
    private static int lengthOfLastWordSplit(String s) {
        String[] strings = s.split(" ");
        System.out.println("strings[] - " + strings.length);
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals(" ")) {
                return strings[i].length();
            }
        }
        return s.length();
    }
}
