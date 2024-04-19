package lists;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 1;
        ListNode tail = head;

        while (tail.next != null) {
            size++;
            tail = tail.next;
        }

        k = k % size;

        if (k == 0) {
            return head;
        }

        ListNode newTail = head;
        for (int i = 1; i < size - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {

    }
}
