package niuke;

/**
 * 反转链表
 */
public class RevertList {

    //{1,2,3,4,5}

    public static void main(String[] args) {
        RevertList test = new RevertList();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;

        System.out.println(test.ReverseList(a1));
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode theNext = null;
        ListNode pre = null;
        ListNode current = head;

        while(current != null) {
            theNext = current.next;
            current.next = pre;
            pre = current;
            current = theNext;
        }

        return pre;
    }
}

class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}