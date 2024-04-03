import java.util.*;

/*
 *
 * Multiply the three largest values
 *
 * */
public class MultiplyOfThree {
    public static void main(String[] args) {
        int[] testArr = {3, 1, 4, 3, 4, 2, 1, 1, 3, 1};
        System.out.println(multiplyOfThreeSort(testArr));
    }

    private static int multiplyOfThreeSort(int[] ints) {
        int result = 1;
        List<Integer> integerList = new ArrayList<>();
        Arrays.stream(ints).forEach(integerList::add);
        integerList.sort(Integer::compareTo);

        for (int i = ints.length - 1; i > ints.length - 4; i--) {
            result *= integerList.get(i);
        }

        return result;
    }
}
