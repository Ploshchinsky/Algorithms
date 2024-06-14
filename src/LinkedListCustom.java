public class LinkedListCustom {
    private Node head;

    public void append(Node newItem) {
        Node current = head;
        if (head == null) {
            head = newItem;
        } else {
            while (true) {
                if (current.getNext() == null) {
                    current.setNext(newItem);
                    return;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    public void delete(Node nodeForDelete) {
        Node current = head;
        Node previous = null;
        while (true) {
            if (current == nodeForDelete) {
                previous.setNext(current.getNext());
                return;
            }
            previous = current;
            current = previous.getNext();
        }
    }

    public void getAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

    }

    public Node getLast() {
        Node current = head;
        while (true) {
            if (current.getNext() == null) {
                return current;
            }
            current = current.getNext();
        }
    }

    public Node pop() {
        Node current = head;
        while (true) {
            if (current.getNext().getNext() == null) {
                Node temp = current.getNext();
                current.setNext(null);
                return temp;
            }
            current = current.getNext();
        }
    }

    public static boolean isLoop(LinkedListCustom list) {
        Node fast = list.head;
        Node slow = list.head;

        try {
            while (true) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
                if (slow == fast) {
                    return true;
                }
            }
        } catch (Exception ex) {
            return false;
        }
    }
}

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Test {
    public static void main(String[] args) {
        Node n1 = new Node("It's a 1");
        Node n2 = new Node("It's a 2");
        Node n3 = new Node("It's a 3");
        Node n4 = new Node("It's a 4");
        Node n5 = new Node("It's a 5");
        Node n6 = new Node("It's a 6");
        Node n7 = new Node("It's a 7");
        Node n8 = new Node("It's a 8");
        LinkedListCustom list = new LinkedListCustom();
        list.append(n1);
        list.append(n2);
        list.append(n3);
        list.append(n4);
        list.append(n5);
        list.append(n6);
        list.append(n7);
        list.append(n8);
        list.getAll();
        System.out.println("----");
        list.delete(n6);
        list.getAll();
        System.out.println("---");
        System.out.println("Last element: " + list.getLast().getData());
        System.out.println("---");
        System.out.println("Pop element: " + list.pop().getData());
        System.out.println("Last element after pop: " + list.getLast().getData());
        System.out.println("---");
        System.out.println("list1 is loop =" + LinkedListCustom.isLoop(list));
        list.append(n7);
        System.out.println("list1 is loop =" + LinkedListCustom.isLoop(list));
    }
}
