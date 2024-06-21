package Queue.DoubleStackQueue;

import java.util.Stack;

public class DoubleStackQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public DoubleStackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(T element) {
        stack1.push(element);
    }

    public T pop() {
        if (stack2.empty()) {
            fillStack2();
        }
        if (stack2.empty()) {
            System.out.println("Queue is empty!");
        }
        return stack2.pop();
    }

    private void fillStack2() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}
