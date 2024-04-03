public class BinaryOperations {
    public static void main(String[] args) {
        for (int i = 1; i <= 32; i++) {
            System.out.println(i + " is even? - " + isEven(i));
            System.out.println(i + " is power of two? - " + isPowerOfTwo(i));
            System.out.println("--------");
        }
    }

    public static boolean isEven(int number) {
        return (number & 1) != 1;
    }

    public static boolean isPowerOfTwo(int number) {
        return (number & number - 1) == 0;
    }
}
