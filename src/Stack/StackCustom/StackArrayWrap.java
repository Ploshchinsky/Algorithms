package Stack.StackCustom;

public class StackArrayWrap {
    private int[] data;
    private int[] min;
    private int[] max;
    private int top;
    private int size;

    public StackArrayWrap(int size) {
        this.data = new int[size];
        this.min = new int[size];
        this.max = new int[size];
        this.size = 0;
    }

    public void push(int number) throws IndexOutOfBoundsException {
        if (size == data.length) {
            throw new IndexOutOfBoundsException(size);
        }
        data[size] = number;
        addToMin(number);
        addToMax(number);
        top = number;
        size++;
    }

    public int peek() {
        return top;
    }

    private void addToMin(int number) {
        if (size == 0) {
            min[size] = number;
            return;
        }
        min[size] = Math.min(number, min[size - 1]);
    }

    private void addToMax(int number) {
        if (size == 0) {
            max[size] = number;
            return;
        }
        max[size] = Math.max(number, max[size - 1]);
    }

    public int pop() {
        int temp = data[size - 1];
        data[size - 1] = 0;
        min[size - 1] = 0;
        size--;
        top = size == 0 ? 0 :data[size-1];
        return temp;
    }

    public int size() {
        return size;
    }

    public int[] printStack() {
        return data;
    }

    public int getMin() {
        if (size == 0) {
            return 0;
        }
        return min[size - 1];
    }

    public int getMax() {
        if (size == 0) {
            return 0;
        }
        return max[size - 1];
    }
}
