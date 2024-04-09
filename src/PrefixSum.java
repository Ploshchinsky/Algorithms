import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * Prefix Sum
 * A prefixSum[] array is created for the input array to store the sum of all elements of the input array.
 *
 * To find the sum of the array with intervals from left to right,
 * it is necessary to call the getSum(left, right) method
 *
 * 1.prefixSumCalculate() - counts the prefix sum
 * 2.prefixSumZeroCalculate() - counts the prefix sum for incoming zeros
 * 3.getSum() - returns the sum of elements in the given interval
 * 4.getSumZero() - returns the amount of zeros in the array
 * 5.getAllZeroValue() - returns number of intervals with zero sum
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

    public int getAllZeroValue() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : prefixSum) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        int zeroCounter = 0;
        for (int key : map.keySet()) {
            if (map.get(key) >= 2) {
                zeroCounter += map.get(key) - 1;
            }
        }
        return zeroCounter;
    }


    public static void main(String[] args) {
//        int[] input = {5, 3, 8, 1, 4, 6, 13, 1, 7};
        int[] input = {2, 5, -5, 0, 1, 1, -2, 9, 0, 0, 4, 8, -8};
//        int[] input = {0, 2, 0, 0, 4, 3, 0};
        int left = 2;
        int right = input.length;
        PrefixSum prefixSum = new PrefixSum(input);

        System.out.println("Prefix Sum " + Arrays.toString(input));
        System.out.println(Arrays.toString(prefixSum.getSum()));

        System.out.printf("\nPrefix sum in interval [%d,%d) - %d", left, right, prefixSum.getSum(left, right));
        System.out.printf("\nZeros in interval [%d,%d) - %d", left, right, prefixSum.getSumZero(left, right));
        System.out.printf("\nNumber of intervals with zero sum - %d", prefixSum.getAllZeroValue());
    }
}
