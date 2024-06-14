public class LinkedListCustom {
    private ListNode head;

    public void append(ListNode newItem) {
        ListNode current = head;
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

    public void delete(ListNode nodeForDelete) {
        ListNode current = head;
        ListNode previous = null;
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
        ListNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

    }

    public ListNode getLast() {
        ListNode current = head;
        while (true) {
            if (current.getNext() == null) {
                return current;
            }
            current = current.getNext();
        }
    }

    public ListNode pop() {
        ListNode current = head;
        while (true) {
            if (current.getNext().getNext() == null) {
                ListNode temp = current.getNext();
                current.setNext(null);
                return temp;
            }
            current = current.getNext();
        }
    }

    public static boolean isLoop(LinkedListCustom list) {
        ListNode fast = list.head;
        ListNode slow = list.head;

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

class ListNode {
    private String data;
    private ListNode next;

    public ListNode(String data) {
        this.data = data;
        next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode("It's a 1");
        ListNode n2 = new ListNode("It's a 2");
        ListNode n3 = new ListNode("It's a 3");
        ListNode n4 = new ListNode("It's a 4");
        ListNode n5 = new ListNode("It's a 5");
        ListNode n6 = new ListNode("It's a 6");
        ListNode n7 = new ListNode("It's a 7");
        ListNode n8 = new ListNode("It's a 8");
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
