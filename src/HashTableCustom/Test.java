package HashTableCustom;

public class Test {
    public static void main(String[] args) {
        HashTableCustom custom = new HashTableCustom();
        for (int i = 0; i < 10; i++) {
            custom.put(i * 2);
        }
        System.out.println("Contain [12]? - " + custom.contain(12));
        System.out.println("Contain [55]? - " + custom.contain(55));
        System.out.println("Contain [11]? - " + custom.contain(11));
        System.out.println("Contain [0]? - " + custom.contain(0));
        System.out.println("Contain [3]? - " + custom.contain(3));
    }
}
