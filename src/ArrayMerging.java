import java.util.Arrays;

public class ArrayMerging {
    private static int[] arrFirst = {1, 1, 5, 8, 12 , 15, 15, 22};
    private static int[] arrSecond = {2, 4, 4, 5, 11, 14};

    public static void main(String[] args) {
        int[] result = arrayMerge(arrFirst, arrSecond);

        System.out.println("First Array: " + Arrays.toString(arrFirst));
        System.out.println("Second Array: " + Arrays.toString(arrSecond));
        System.out.println("Resul massive: " + Arrays.toString(result));
    }

    private static int[] arrayMerge(int[] array1, int[] array2) {
        int[] lArr = array1.length < array2.length ? array1 : array2;
        int[] rArr = array1.length > array2.length ? array1 : array2;
        int right = 0, left = 0;
        int resultSize = array1.length + array2.length;
        int[] result = new int[resultSize];

        for (int i = 0; i < resultSize; i++) {
            if (left <= lArr.length -1) {
                if (lArr[left] <= rArr[right]) {
                    result[i] = lArr[left];
                    left++;
                    continue;
                } else {
                    result[i] = rArr[right];
                    right++;
                    continue;
                }
            }
            result[i] = rArr[right];
            right++;
        }
        return result;
    }
}
