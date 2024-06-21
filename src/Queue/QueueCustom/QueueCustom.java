package Queue.QueueCustom;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QueueCustom {
    private int[] data;
    private int beginIndex, endIndex, currentSize;

    public QueueCustom(int size) {
        this.data = new int[size];
        this.beginIndex = -1;
        this.endIndex = -1;
        this.currentSize = 0;
    }

    public void push(int number) {
        if (isEmpty()) {
            data[currentSize] = number;
            queueReset();
            return;
        }
        int tempIndex = endIndex;
        if (endIndex + 1 >= data.length) {
            endIndex = -1;
        }
        if (data[endIndex + 1] == 0) {
            data[endIndex + 1] = number;
            currentSize++;
        } else {
            endIndex = tempIndex;
            System.out.println("Queue is full!");
        }
        endIndex++;
    }

    private void queueReset() {
        beginIndex = 0;
        endIndex = 0;
        currentSize++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int temp = data[beginIndex];
        data[beginIndex] = 0;
        beginIndex++;
        if (beginIndex >= data.length) {
            beginIndex = 0;
        }
        currentSize--;
        if (isEmpty()) {
            queueReset();
        }
        return temp;
    }

    public boolean isFull() {
        return endIndex >= data.length - 1;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public String toString() {
        return "QueueCustom{" +
                "data=" + Arrays.toString(data) +
                ", beginIndex=" + beginIndex +
                ", endIndex=" + endIndex +
                ", currentSize=" + currentSize +
                '}';
    }
}
