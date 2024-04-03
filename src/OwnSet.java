import java.util.ArrayList;
import java.util.List;

/*
 *
 * Own Set
 * Proprietary implementation of Set using List<>

 * */
public class OwnSet {
    public static void main(String[] args) {
        TestSet mySet = new TestSet(3);
        mySet.add(5);
        mySet.add(17);
        mySet.add(14);
        mySet.add(1);
        mySet.add(6);
        mySet.add(21);
        mySet.delete(17);

        System.out.println("Amount of numbers - " + mySet.size());
        System.out.println("Number 21 is exist? - " + mySet.isExist(21));
        System.out.println("Number 14 is exist? - " + mySet.isExist(14));
    }
}

class TestSet {
    private Integer size;
    private ArrayList<Integer>[] storage;

    public TestSet(int size) {
        this.size = size;
        this.storage = new ArrayList[size];
    }

    private int getHash(int number) {
        int hash = number % size;
        return hash;
    }

    public void add(int number) {
        int hash = getHash(number);
        if (storage[hash] == null) {
            storage[hash] = new ArrayList<>();
            storage[hash].add(number);
        } else {
            storage[hash].add(number);
        }
    }

    public boolean isExist(int number) {
        int hash = getHash(number);
        if (!storage[hash].isEmpty()) {
            for (int num : storage[hash]) {
                if (num == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        int size = 0;
        for (ArrayList<Integer> list : storage) {
            size += list == null ? 0 : list.size();
        }
        return size;
    }

    public void delete(int number) {
        int hash = getHash(number);
        if (storage[hash] != null && !storage[hash].isEmpty()) {
            for (int i = 0; i < storage[hash].size(); i++) {
                if (storage[hash].get(i) == number) {
                    storage[hash].set(i, storage[hash].getLast());
                    storage[hash].removeLast();
                    break;
                }
            }
        }
    }
}