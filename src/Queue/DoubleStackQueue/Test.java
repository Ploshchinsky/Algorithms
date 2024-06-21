package Queue.DoubleStackQueue;

public class Test {
    public static void main(String[] args) {
        DoubleStackQueue<Integer> queue = new DoubleStackQueue<>();
        queue.push(11);
        queue.push(22);
        queue.push(33);
        queue.push(44);
        queue.push(55);

        System.out.println(queue.pop());

        queue.push(66);
        queue.push(77);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
