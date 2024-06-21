package Stack.StackCustom;

public class StackArrayWrap {
    private int[] data;
    private int[] min;
    private int size;

    public StackArrayWrap(int size) {
        this.data = new int[size];
        this.min = new int[size];
        this.size = 0;
    }

    public void push(int number) throws IndexOutOfBoundsException {
        if (size == data.length) {
            throw new IndexOutOfBoundsException(size);
        }
        data[size] = number;
        addToMin(number);
        size++;
    }

    private void addToMin(int number) {
        if (size == 0) {
            min[size] = number;
            return;
        }
        min[size] = Math.min(number, min[size - 1]);
    }

    public int pop() {
        int temp = data[size - 1];
        data[size - 1] = 0;
        min[size - 1] = 0;
        size--;
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
}
