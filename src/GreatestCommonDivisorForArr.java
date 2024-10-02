import java.util.Arrays;

public class GreatestCommonDivisorForArr {
    public static int[] arr1 = {18, 12, 36, 60};
    public static int[] arr2 = {21, 126, 63};

    public static void main(String[] args) {
        System.out.println(gcdOptimized(arr1));
        System.out.println(gcdOptimized(arr2));
        System.out.println(gcd(15,7));
    }

    //BrutForce O(n^2)
    private static int gcdBrutForce(int[] arr) {
        int min = Arrays.stream(arr).min().isPresent() ? Arrays.stream(arr).min().getAsInt() : arr[0];
        for (int i = min; i > 0; i--) {
            int divisor = i;
            if (Arrays.stream(arr).allMatch(num -> num % divisor == 0))
                return i;
        }
        return -1;
    }

    private static int gcdOptimized(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) {
                return result;
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
