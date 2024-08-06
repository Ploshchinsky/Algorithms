package LeetCode;

import java.util.Collections;
import java.util.Map;

public class LongestPalindromicSubstring {
    //Input: s = "babad"
    //Output: "bab"
    //Explanation: "aba" is also a valid answer.

    public static void main(String[] args) {
        System.out.println(longestPalindrome("borcdubqiupahpwjizjjbkncelfazeqynfbrnzuvbhjnyvrlkdyfyjjxnprfocrmisugizsgvhszooktdwhehojbrdbtgkiwkhpfjfcstwcajiuediebdhukqnroxbgtvottummbypokdljjvnthcbesoyigscekrqswdpalnjnhcnqrarxuufzzmkwizptyvjhpfidgmskuaggtpxqisdlyloznkarxofzeeyvteynluofuhbllyiszszbwnsglqjkignusarxsjvctpgiwnhdufmfpanfwxjwlmhgllzsmdpncbwnsbdtsvrjybynifywkulqnzprcxockbhrhvnwxrkvwumyieazclcviumvormynbryaziijpdinwatwqppamfiqfiojgwkvfzyxadyfjrgmtttvlgkqghgbcfhkigfojjkhskzenlpasyozcsuccdxhulcubsgomvcrbqwakrraesfifecmoztayrdjicypakrrneulfbqqxtrdelggedvloebqaztmfyfkhuonrognejxpesmwgnmnnnamvkxqvzrgzdqtvuhccryeowywmbixktnkqnwzlzfvloyqcageugmjqihyjxhssmhkfzxpzxmgpjgsduogfolnkkqizitbvvgrkczmojxnabruwwzxxqcevdwvtiigwckpxnnxxxdhxpgomncttjutrsvyrqcfwxhexhaguddkiesmfrqfjfdaqbkeqinwicphktffuwcazlmerdhraufbpcznbuipmymipxbsdhuesmcwnkdvilqbnkaglloswcpqzdggnhjdkkumfuzihilrpcvemwllicoqiugobhrwdxtoefynqmccamhdtxujfudbglmiwqklriolqfkknbmindxtljulnxhipsieyohnczddabrxzjmompbtnnxvivmoyfzfrxlufowtqzojfclmatthjtbhotdoheusnpirwicbtyrcuojsdmfcx"));
    }

    public static String longestPalindrome(String s) {
        String palindrome = "";
        if (s.length() == 1) {
            return s;
        }
        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length(); right > left; right--) {
                if (s.toCharArray()[left] == s.toCharArray()[right-1]) {
                    if (isPalindrome(s.substring(left, right))
                            && s.substring(left, right).length() > palindrome.length()) {
                        palindrome = s.substring(left, right);
                    }
                }
            }
        }
        return palindrome;
    }

    public static boolean isPalindrome(String string) {
        if (string.length() % 2 == 0) {
            int mid = string.length() / 2;
            String left = string.substring(0, mid);
            StringBuilder right = new StringBuilder((string.substring(mid, string.length())));
            return right.reverse().toString().equals(left);
        } else {
            int mid = string.length() / 2;
            String left = string.substring(0, mid);
            StringBuilder right = new StringBuilder((string.substring(mid + 1, string.length())));
            return right.reverse().toString().equals(left);
        }
    }
}
