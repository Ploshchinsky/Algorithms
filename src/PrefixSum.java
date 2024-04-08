import java.util.Arrays;

/*
 *
 * Prefix Sum
 * A prefixSum[] array is created for the input array to store the sum of all elements of the input array.
 *
 * To find the sum of the array with intervals from left to right,
 * it is necessary to call the getSum(left, right) method
 *
 * */
public class PrefixSum {
    private static int[] prefixSum;
    private static int[] prefixSumZeros;

    public PrefixSum(int[] array) {
        prefixSumCalculate(array);
        prefixSumZeroCalculate(array);
    }

    private void prefixSumZeroCalculate(int[] array) {
//        {0, 2, 0, 0, 4, 3, 0}
        prefixSumZeros = new int[array.length + 1];
        prefixSumZeros[0] = 0;
        int sum = 0;
        for (int i = 1; i < prefixSumZeros.length; i++) {
            if (array[i - 1] == 0) {
                sum++;
            }
            prefixSumZeros[i] = sum;
        }

    }

    private static void prefixSumCalculate(int[] array) {
        prefixSum = new int[array.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
    }

    public int getSum(int left, int right) {
        return prefixSum[right] - prefixSum[left];
    }

    public int getSumZero(int left, int right) {
        return prefixSumZeros[right] - prefixSumZeros[left];
    }

    public int[] getSum() {
        return prefixSum;
    }


    public static void main(String[] args) {
//        int[] input = {5, 3, 8, 1, 4, 6, 13, 1, 7};
        int[] input = {0, 2, 0, 0, 4, 3, 0};
        int left = 2;
        int right = input.length;
        PrefixSum prefixSum = new PrefixSum(input);

        System.out.println("Prefix Sum " + Arrays.toString(input));
        System.out.println(Arrays.toString(prefixSum.getSum()));

        System.out.printf("\nPrefix sum in interval [%d,%d) - %d", left, right, prefixSum.getSum(left, right));
        System.out.printf("\nPrefix sum zeros in interval [%d,%d) - %d", left, right, prefixSum.getSumZero(left, right));
    }
}
