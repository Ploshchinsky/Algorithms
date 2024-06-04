import java.util.Arrays;

public class ArrayZeroShifter {
    public static void main(String[] args) {
        int[] input = {8, 3, 2, 0, 0, 1, 0};
        System.out.println(Arrays.toString(zeroShifter(input)));
    }

    private static int[] zeroShifter(int[] array) {
        int[] result = new int[array.length];
        int resulIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                result[resulIndex] = array[i];
                resulIndex++;
            }
        }
        return result;
    }
}
