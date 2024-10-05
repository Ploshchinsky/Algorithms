import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int min = 98;
        int max = 134;
        System.out.println(findNumberWithUniqueDigits(min, max));
    }

    private static List<Integer> findNumberWithUniqueDigits(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (isUniqueDigits(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isUniqueDigits(int number) {
        int[] arr = new int[10];
        while (number > 0) {
            if (arr[number % 10] > 0) {
                return false;
            }
            arr[number % 10]++;
            number /= 10;
        }
        return true;
    }

    private static boolean isUniqueDigitsMap(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        while (number > 0) {
            if (map.containsKey(number % 10)) {
                return false;
            }
            map.put(number % 10, map.getOrDefault(number % 10, 0) + 1);
            number /= 10;
        }
        return true;
    }
}
