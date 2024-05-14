import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int[] intArr = {2, 9, 11, 1, 3, 0, 5, 7, 4, 6, 10, 8};
        System.out.println(Arrays.toString(mergeSorting(intArr)));
    }

    private static int[] mergeSorting(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int[] left = mergeSorting(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] right = mergeSorting(Arrays.copyOfRange(array, array.length / 2, array.length));
        int[] result = arraysMerge(left, right);
        return result;
    }

    private static int[] arraysMerge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[i] = left[l];
                    l++;
                } else {
                    result[i] = right[r];
                    r++;
                }
            } else {
                if (l >= left.length) {
                    while (r < right.length) {
                        result[i] = right[r];
                        r++;
                        i++;
                    }
                } else {
                    while (l < left.length) {
                        result[i] = left[l];
                        l++;
                        i++;
                    }
                }
            }
        }
        return result;
    }
}
