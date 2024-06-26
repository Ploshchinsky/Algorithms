/*
 *
 * FizzBuzz
 *
 * Output numbers from 1 to 100.
 * If the number is a multiple of 3, print Fizz,
 * if the number is a multiple of 5, print Buzz,
 * if the number is a multiple of both 3 and 5, print FizzBuzz.
 *
 * */
public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz();
        System.out.println("The End");
    }

    private static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
