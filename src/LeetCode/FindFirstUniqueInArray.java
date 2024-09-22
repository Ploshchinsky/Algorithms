package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class FindFirstUniqueInArray {
    public static void main(String[] args) {
        int[] arr = {5, 0, 9
                , 3, 0, 7, 5, 3, 9};
        System.out.println(findFirsUnique(arr));
    }

    private static int findFirsUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(value -> {
            map.put(value, map.getOrDefault(value, 0) + 1);
        });
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
