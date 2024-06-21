package StackCustom;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        StackArrayWrap stack = new StackArrayWrap(10);
        for (int i = 0; i < 10; i++) {
            stack.push(new Random().nextInt(20) + 1);
        }


        System.out.println(Arrays.toString(stack.printStack()));
        System.out.println("Min - " + stack.getMin());
        while (stack.size() != 0) {
            stack.pop();
            System.out.println(Arrays.toString(stack.printStack()));
            System.out.println("Min - " + stack.getMin());
        }
    }
}
