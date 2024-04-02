public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 4, 5, 8, 10, 3, 2, 0, 1};
        int target = 2;
        System.out.println(indexFirstIn(arr, target));
        System.out.println(indexLastIn(arr, target));
    }

    public static int indexFirstIn(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int indexLastIn(int[] arr, int target) {
        for (int i = (arr.length - 1); i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
