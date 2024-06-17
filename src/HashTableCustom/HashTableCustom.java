package HashTableCustom;

public class HashTableCustom {
    private Node[] buckets;
    private int actualSize;

    public HashTableCustom(int capacity) {
        buckets = new Node[capacity];
    }

    public HashTableCustom() {
        buckets = new Node[10];
    }

    public void put(int value) {
        int key = hash(value);
        Node temp = null;
        if (buckets[key] == null) {
            buckets[key] = new Node(value);
        } else {
            while (true) {
                temp = buckets[key];
                if (temp.getNext() == null) {
                    temp.setNext(new Node(value));
                    return;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public boolean contain(int value) {
        int key = hash(value);
        Node temp = null;
        if (buckets[key] != null) {
            temp = buckets[key];
            while (true) {
                if (temp.getValue() == value) {
                    return true;
                } else {
                    temp = temp.getNext();
                }
            }
        }
        return false;
    }

    private int hash(int value) {
        return (value ^ (value >> 16)) % buckets.length;
    }
}
