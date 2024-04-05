import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Sorting by Counting
 *
 * Given: Array of N numbers, with each number from X to Y.
 * The interval MAX(x,y) - MIN(x,y) = K.
 * Task: Sort and return the array using sorting by counting
 * (check each number from the original array and add +1 if this number has already occurred).
 *
 * */
public class SortByCounting {
    private static int[] inputArr = {1, 2, 5, 5, 3, 3, 3, 2};
    private static int[] inputArr2 = {1, 2, 5, 5, 3, 3, 3, 2, 4, 6, 9, 7, 4, 4, 1, 9};
    private static int[] inputArr3 = {4, 2, 4};

    public static void main(String[] args) {
        inputArr = sortByCounting(inputArr);
        System.out.println(Arrays.toString(inputArr));

        inputArr2 = sortByCounting(inputArr2);
        System.out.println(Arrays.toString(inputArr2));

        inputArr3 = sortByCounting(inputArr3);
        System.out.println(Arrays.toString(inputArr3));

        //Alternative sort by counting with HashMap
        inputArr = sortByCountingPlus(inputArr);
        System.out.println("\n" + Arrays.toString(inputArr));

        inputArr2 = sortByCountingPlus(inputArr2);
        System.out.println(Arrays.toString(inputArr2));

        inputArr3 = sortByCountingPlus(inputArr3);
        System.out.println(Arrays.toString(inputArr3));
    }

    public static int[] sortByCounting(int[] array) {
        int max, min, nowPos;
        int[] res = new int[array.length];
        if (array.length > 2) {
            min = Arrays.stream(array).min().getAsInt();
            max = Arrays.stream(array).max().getAsInt();

            int[] sortedArr = new int[(max - min) + 1];
            Arrays.stream(sortedArr).forEach(number -> number = 0);

            //Fill sortedArr
            for (int i = 0; i < array.length; i++) {
                int current = array[i];
                sortedArr[current - min]++;
            }
            //Fill result arr
            nowPos = 0;
            for (int i = 0; i < sortedArr.length; i++) {
                for (int j = 0; j < sortedArr[i]; j++) {
                    res[nowPos] = i + min;
                    nowPos++;
                }
            }
            return res;
        } else if (array.length == 2) {
            min = Math.min(array[0], array[1]);
            max = Math.max(array[0], array[1]);
            return new int[]{min, max};
        } else if (array.length <= 1) {
            System.out.println("Array is too short (1 element or 0)");
        }
        return array;
    }

    public static int[] sortByCountingPlus(int[] array) {
        Map<Integer, Integer> sortedMap = new HashMap<>();
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (!sortedMap.containsKey(array[i])) {
                sortedMap.put(array[i], 1);
            } else {
                sortedMap.put(array[i], sortedMap.get(array[i]) + 1);
            }
        }

        int position = 0;
        for (Integer key : sortedMap.keySet()) {
            for (int i = 0; i < sortedMap.get(key); i++) {
                result[position] = key;
                position++;
            }
        }
        return result;
    }
}
