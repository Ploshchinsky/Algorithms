import java.util.Arrays;

public class PrefixSum {
    private static int[] prefixSum;

    public PrefixSum(int[] array) {
        prefixSum = new int[array.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
    }

    public int getSum(int left, int right) {
        return prefixSum[right] - prefixSum[left];
    }

    public int[] getSum() {
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] input = {5, 3, 8, 1, 4, 6, 13, 1, 7};
        int left = 2;
        int right = 4;
        PrefixSum prefixSum = new PrefixSum(input);

        System.out.println("Prefix Sum " + Arrays.toString(input));
        System.out.println(Arrays.toString(prefixSum.getSum()));

        System.out.printf("\nPrefix sum in interval [%d,%d) - %d", left, right, prefixSum.getSum(left, right));
    }
}
