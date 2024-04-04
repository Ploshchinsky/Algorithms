import java.util.*;

/*
 *
 * Sum of Two in Array
 *
 * Given: an array of numbers and a number X
 * Task: find two different numbers that add up to X.
 * If there are none, print 0,0.
 *
 * */
public class SumOfTwoInArr {
    public static void main(String[] args) {
        int size = 10;
        int target = 8;
        int[] intArr = randomArr(size);
//        int[] intArr = {9, 0, 4, 5, 3, 1, 2};
        System.out.println(Arrays.toString(sumOfTwo(intArr, target)));
    }

    private static int[] sumOfTwo(int[] arr, int target) {
        int[] result = {0, 0};
        List<Integer> integerList = new ArrayList<>();
        integerList.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (integerList.contains(target - arr[i])) {
                result[0] = arr[i];
                result[1] = target - arr[i];
                return result;
            }
            integerList.add(arr[i]);
        }

        return result;
    }

    private static int[] randomArr(int size) {
        int[] tempArr = new int[size];
        for (int i = 0; i < size; i++) {
            tempArr[i] = new Random().nextInt(11);
        }
        return tempArr;
    }
}
