package LeetCode;

import java.util.Arrays;

//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
public class PlusOne {
    public static void main(String[] args) {
        int[] t1 = {4, 3, 2, 1};
        int[] t2 = {9, 9};
        int[] t3 = {1, 3, 9, 9};
        System.out.println(Arrays.toString(plusOne(t1)));
        System.out.println(Arrays.toString(plusOne(t2)));
        System.out.println(Arrays.toString(plusOne(t3)));
    }

    private static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }

        while (digits[lastIndex] == 9) {
            digits[lastIndex] = 0;
            lastIndex--;
            if (lastIndex < 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
        }
        digits[lastIndex] = digits[lastIndex] + 1;
        return digits;
    }
}
