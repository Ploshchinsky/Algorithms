import java.util.List;

public class FindMaxInRange {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 12, 33, 0, 16, 9, 2, 28);
        int min = 3;
        int max = 30;
        System.out.println(findMaxInRange(list, min, max));
        System.out.println(findMinInRange(list, min, max));
    }

    private static int findMinInRange(List<Integer> list, int min, int max) {
        int result = findMaxInRange(list,min,max);
        for (Integer i : list) {
            if (i >= min && i <= max) {
                result = Math.min(result, i);
            }
        }
        return result;
    }

    private static int findMaxInRange(List<Integer> list, int min, int max) {
        int result = list.getFirst();
        for (Integer i : list) {
            if (i >= min && i <= max) {
                result = Math.max(result, i);
            }
        }
        return result;
    }
}
