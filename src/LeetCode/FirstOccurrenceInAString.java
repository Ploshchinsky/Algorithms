package LeetCode;

//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.

public class FirstOccurrenceInAString {
    static String haystack2 = "leetcode";
    static String haystack1 = "sadbutsad";

    public static void main(String[] args) {
        System.out.println(strStr(haystack1, "uts"));
    }

    private static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            for (int i = 0; i < haystack.length(); i++) {
                int start = i;
                int end = i + needle.length();
                if (haystack.substring(start, end).equals(needle)) {
                    return start;
                }
            }
        }
        return -1;
    }
}
