import java.util.List;

public class FindMaxInRange {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 12, 33, 0, 16, 9, 2, 31);
        int min = 3;
        int max = 30;
        System.out.println("Maximum");
        System.out.println(findMaxInRange(list, min, max));
        System.out.println(findIndexInRange(list, min, max));
        System.out.println("Minimum");
        System.out.println(findMinInRange(list, min, max));
    }

    private static int findIndexInRange(List<Integer> list, int min, int max) {
        int maximum = 0;

        for (Integer i : list) {
            if (i >= min && i <= max) {
                maximum = Math.max(i, maximum);
            }
        }

        return list.indexOf(maximum);
    }

    private static int findMinInRange(List<Integer> list, int min, int max) {
        int result = findMaxInRange(list, min, max);
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
