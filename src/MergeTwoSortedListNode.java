public class MergeTwoSortedListNode {
    //Input: list1 = [1,2,4], list2 = [1,3,4]
    //Output: [1,1,2,3,4,4]
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4, null)));
        ListNode l2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4, null)));
        ListNode r = mergeTwoLists(l1, l2);
        System.out.println(r);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list1 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return result.next;
    }
}


