import java.util.ArrayList;
import java.util.List;

public class ArrayDifference {
    public static int[] arr1 = {-10, -20, 5, 2, 2, -10, 6};
    public static int[] arr2 = {-20, 1, 3, 3, 7, 6, 0, 0};

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(diffArr(arr1, arr2));
        integers.addAll(diffArr(arr2, arr1));
        System.out.println(integers);
    }

    private static List<Integer> diffArr(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    break;
                }
                if (j == arr2.length - 1) {
                    result.add(arr1[i]);
                }
            }
        }
        return result;
    }

    private static List<Integer> diffArrWithFlag(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean isExist;
        for (int i = 0; i < arr1.length; i++) {
            isExist = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    isExist = true;
                    break;
                }
                if (j == arr2.length - 1) {
                    result.add(arr1[i]);
                }
            }
            if (!isExist) {
                result.add(arr1[i]);
            }
        }
        return result;
    }
}
