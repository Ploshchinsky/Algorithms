import java.util.*;

public class DuplicateDetector {
    public static void main(String[] args) {
        List<int[]> integersList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integersList.add(arrayIntGenerator(i + 1));
        }
        for (int[] array : integersList) {
            System.out.println("Input array: " + Arrays.toString(array));
            duplicateDetector(array);
            System.out.println("-------\n");
        }
    }

    private static int[] arrayIntGenerator(int arraySize) {
        int[] result = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            if (i != 0 && i % 3 == 0) {
                result[i] = result[i - 2];
                continue;
            }
            result[i] = new Random().nextInt(10);
        }
        return result;
    }

    private static void duplicateDetector(int[] array) {
        Set<Integer> integerSet = new HashSet<>();
        int dupCount = 0;
        for (int i = 0; i < array.length; i++) {
            integerSet.add(array[i]);
            if (integerSet.size() != (i + 1) - dupCount) {
                System.out.println("Duplicate has found it: " + array[i]);
                dupCount++;
            }
        }
    }
}
