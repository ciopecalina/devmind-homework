package lists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode result = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
