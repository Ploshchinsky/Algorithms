package Queue.QueueCustom;

public class Test {
    public static void main(String[] args) {
//        int[] numbers = {8, 5, 11, 1, 13, 22};
        QueueCustom queueCustom = new QueueCustom(4);
        queueCustom.push(8);
        queueCustom.push(5);
        queueCustom.push(11);
        queueCustom.push(1);
        queueCustom.pop(); // popped 8
        queueCustom.pop(); // popped 5
        queueCustom.push(13);
        queueCustom.push(22);
        queueCustom.pop(); // popped 11
        queueCustom.pop(); // popped 1
        queueCustom.push(19);
        queueCustom.pop(); // popped 13
        queueCustom.pop(); // popped 22
        System.out.println("Last popped element (19) - " + queueCustom.pop());
    }
}
