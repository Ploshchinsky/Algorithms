package LeetCode;

import java.util.Arrays;
//Example 2:
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

public class SqrtFromX {
    public static void main(String[] args) {
        int[] test = {4, 9, 16, 15, 8, 3, 2147395600};
        System.out.println(binarySqrtFrom(2147395600));
        Arrays.stream(test).forEach(value -> System.out.println(binarySqrtFrom(value)));
    }

    //Complexity O(log n)
    private static int binarySqrtFrom(int target) {
        long left = 0;
        long right = target;
        long mid = target / 2;

        while (true) {
            if (mid * mid <= target && (mid +1) * (mid + 1) > target) {
                return (int) mid;
            }
            if (mid * mid > target) {
                right = mid;
                mid = (right + left) / 2;
                continue;
            }
            if (mid * mid < target) {
                left = mid;
                mid = (right + left) / 2;
            }
        }
    }

    //Complexity O(sqrt(n))
    private static int sqrtFrom(int x) {
        long current = 1;
        while (current * current <= x) {
            current++;
        }
        return (int) current - 1;
    }
}
