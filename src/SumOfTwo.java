import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {
    /*
    Sum of Two
    * Given: an array of numbers and a target number
    * Problem: find (if there are) 2 numbers in the array, which together will give a target number
    * */
    public static void main(String[] args) {
        int[] numbers = {0, 11, 23, -5, 17, 5, 9, 3};
        int target = 12;
        sumOfTwo(numbers, target);
    }

    private static void sumOfTwo(int[] array, int target) {
        int a, b;
        Map<Integer, Integer> numberIndex = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int temp = target - array[i];
            if (numberIndex.containsKey(temp)) {
                System.out.println(array[i] + "[" + i + "]" + " + " + temp + "[" + numberIndex.get(temp) + "]" + " = " + target);
            }
            numberIndex.put(array[i], i);
        }
    }
}
