import java.util.*;

public class RopeMinAmount {
    /*
     *
     * Rope Min Amount
     *
     * Given: an array of numbers, where each number is a rope of length N
     * Task: to find the minimum value of the union of two ropes, and then sum up
     * the obtained values and get the total value of the union.
     * Find the minimum final sum of the unions of the array
     *
     * */
    public static void main(String[] args) {
        int size = 4;
        int[] array = {5, 4, 2, 8}; // 4+2=6 > [5,8,6]; 5+6=11 > [8,11]; 8+11=19 > []; 6+11+19=36
        int[] arrayRndm = new int[size];
        for (int i = 0; i < size; i++) {
            arrayRndm[i] = new Random().nextInt(50);
        }
        System.out.println("Method used ArrayList:");
        System.out.println(Arrays.toString(array));
        System.out.println(findRopeMin_list(array));
        System.out.println("---");
        System.out.println(Arrays.toString(arrayRndm));
        System.out.println(findRopeMin_list(arrayRndm));
        System.out.println("\nMethod used PriorityQueue:");
        System.out.println(Arrays.toString(array));
        System.out.println(findRopeMin_heap(array));
        System.out.println("---");
        System.out.println(Arrays.toString(arrayRndm));
        System.out.println(findRopeMin_heap(arrayRndm));

    }

    private static int findRopeMin_list(int[] array) {
        List<Integer> integerList = new ArrayList<>();
        Arrays.stream(array).forEach(integerList::add);
        integerList.sort(Integer::compareTo);
        int result = 0;

        while (integerList.size() > 1) {
            int first = integerList.removeFirst();
            int second = integerList.removeFirst();
            int sum = first + second;
            result += sum;
            integerList.add(sum);
            integerList.sort(Integer::compareTo);
        }
        return result;
    }

    private static int findRopeMin_heap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.stream(arr).forEach(heap::add);
        int result = 0;

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            int sum = first + second;
            heap.add(sum);
            result += sum;
        }
        return result;
    }
}
