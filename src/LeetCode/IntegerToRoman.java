package LeetCode;
//Input: num = 58
//
//Output: "LVIII"
//
//Explanation:
//
//50 = L
// 8 = VIII

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
    public static final Map<Integer, String> ROMAN = new LinkedHashMap<>();
    public static String[] romanStr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static int[] romanNum = {1_000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    static {
        ROMAN.put(1000, "M");
        ROMAN.put(900, "CM");
        ROMAN.put(500, "D");
        ROMAN.put(400, "CD");
        ROMAN.put(100, "C");
        ROMAN.put(90, "XC");
        ROMAN.put(50, "L");
        ROMAN.put(40, "XL");
        ROMAN.put(10, "X");
        ROMAN.put(9, "IX");
        ROMAN.put(5, "V");
        ROMAN.put(4, "IV");
        ROMAN.put(1, "I");
    }

    public static void main(String[] args) {
        int t1 = 98;
        int t2 = 17;
        int t3 = 737;
        System.out.println(integerToRomanHashMap(t1));
        System.out.println(integerToRomanHashMap(t2));
        System.out.println(integerToRomanHashMap(t3));
        System.out.println("---");
        System.out.println(integerToRomanArrays(t1));
        System.out.println(integerToRomanArrays(t2));
        System.out.println(integerToRomanArrays(t3));
    }

    private static String integerToRomanHashMap(int number) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ROMAN.keySet().size(); i++) {
            for (int value : ROMAN.keySet()) {
                while (number >= value) {
                    result.append(ROMAN.get(value));
                    number -= value;
                }
            }
        }
        return result.toString();
    }

    private static String integerToRomanArrays(int num) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < romanStr.length; i++) {
            while (num >= romanNum[i]) {
                result.append(romanStr[i]);
                num -= romanNum[i];
            }
        }
        return result.toString();
    }
}
