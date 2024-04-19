package lists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}

public class RemoveDuplicatesFromSortedList {


    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        ListNode result1 = ListNode.deleteDuplicates(head1);
        System.out.println("Test Case 1:");
        ListNode.printList(result1); // Expected output: [1, 2]

//        // Test case 2
//        ListNode head2 = new ListNode(1);
//        head2.next = new ListNode(1);
//        head2.next.next = new ListNode(2);
//        head2.next.next.next = new ListNode(3);
//        head2.next.next.next.next = new ListNode(3);
//
//        ListNode result2 = deleteDuplicates(head2);
//        System.out.println("\nTest Case 2:");
//        ListNode.printList(result2); // Expected output: [1, 2, 3]
    }
}
