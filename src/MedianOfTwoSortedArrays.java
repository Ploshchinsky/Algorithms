import java.util.Arrays;
/*
*
* Median of two sorted arrays
*
* */

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2, -1};
        System.out.println(medianOfArrays(nums1, nums2));
    }

    private static double medianOfArrays(int[] nums1, int[] nums2) {
        int[] res = arrayMerge(nums1, nums2);
        if (res.length % 2 == 0) {
            int n1 = res[res.length / 2 - 1];
            int n2 = res[res.length / 2];
            return (double) (n1 + n2) / 2;
        }
        return res[res.length / 2];
    }

    private static int[] arrayMerge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        Arrays.sort(result);
        return result;
    }
}
