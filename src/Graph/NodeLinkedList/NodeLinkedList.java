package Graph.NodeLinkedList;

public class NodeLinkedList {
    static class Node {
        int value;
        Node nextNode;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public static Node nodeConstruct(Node root, int size) {
            if (size <= 0) {
                return root;
            }
            return nodeConstruct(new Node(size - 1, root), size - 1);
        }

        public static Node reverseList(Node linkedList) {
            Node perv = null;
            Node current = linkedList;
            while (current != null) {
                Node next = current.nextNode;
                current.nextNode = perv;
                perv = current;
                current = next;
            }
            return perv;
        }

        public void printList() {
            Node temp = this;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.nextNode;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node node = Node.nodeConstruct(null, 5);
        System.out.println("List after reverse:");
        node.printList();
        System.out.println("List before reverse:");
        node = Node.reverseList(node);
        node.printList();
    }
}
