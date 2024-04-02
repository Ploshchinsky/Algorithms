/*
Linear search algorithms.
    1. indexFirstIn - search for the first occurrence of a number in the array
    2. indexLastIn - search for the last occurrence of a number in the array
    3. maximum - finds the maximum value in the array
    4. maximumPlus - finds the maximum 2 values in the array
    5. minimumEven - finds the minimum even value in the array

*/

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 4, 5, 8, 10, 3, 2, 0, 1};
        int[] arr2 = {0, 2};
        int target = 2;
        //indexFirstIn
        System.out.println(indexFirstIn(arr, target));
        //indexLastIn
        System.out.println(indexLastIn(arr, target));
        //maximum
        System.out.println(maximum(arr));
        //maximumPlus
        System.out.println(Arrays.toString(maximumPlus(arr)));
        //minimumEven
        System.out.println(minimumEven(arr));
    }

    public static int indexFirstIn(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int indexLastIn(int[] arr, int target) {
        for (int i = (arr.length - 1); i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int maximum(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static int[] maximumPlus(int[] arr) {
        int max1 = Integer.max(arr[0], arr[1]);
        int max2 = Integer.min(arr[0], arr[1]);

        if (arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] > max1) {
                    max2 = max1;
                    max1 = arr[i];
                } else if (arr[i] > max2) {
                    max2 = arr[i];
                }
            }
        }

        return new int[]{max1, max2};
    }

    public static int minimumEven(int[] arr) {
        int min = arr[0];
        boolean isExist = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= min) {
                min = arr[i];
                isExist = true;
            }
        }
        return isExist ? min : -1;
    }
}
