/*
 *
 * Greatest Common Divisor
 *
 * Given: Two numbers
 * Problem: Find the greatest common divisor of two numbers
 *
 * */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int n1 = 21;
        int n2 = 90;
        System.out.printf("Greatest Common Division for [%d], [%d] - %d", n1, n2, gcd(n1, n2));
    }

    private static int gcd(int number1, int number2) {
        int smaller = Math.min(number1, number2);
        int bigger = Math.max(number1, number2);

        for (int i = smaller; i > 0; i--) {
            if (smaller % i == 0 && bigger % i == 0) {
                return i;
            }
        }

        return -1;
    }
}
