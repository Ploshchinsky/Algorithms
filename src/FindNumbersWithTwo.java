public class FindNumbersWithTwo {
    public static int[] arr = {0, 15, 2, 13, 37, 122, 22}; // digits of 2 = 5

    public static void main(String[] args) {
        int target = 3;
        System.out.println(findAllDigit(arr, target));
    }

    private static int findAllDigit(int[] arr, int target) {
        int result = 0;
        for (int i : arr) {
            result += countOfDigit(i, target);
        }
        return result;
    }

    private static int countOfDigit(int number, int target) {
        int count = 0;
        while (number > 0) {
            if (number % 10 == target) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
