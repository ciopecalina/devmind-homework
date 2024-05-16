package lists;

public class MiddleOfTheLinkedList {
    public static int size(ListNode head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }

    public static ListNode middleNode(ListNode head) {

        ListNode temp = head;

        int size = size(head);

        for (int i = 0; i < size / 2; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {

    }
}
