package test;

public class Test1 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        ListNode n5 = new ListNode();

        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode result = removeNthFromEnd(n1, 1);

        System.out.println("test");
    }

    //删除倒数第n个
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null) {
            return head;
        }

        int count = 0;

        ListNode current = head;

        while(current != null) {
            count ++;
            if(current.next == null) {
                break;
            }

            current = current.next;
        }

        int local = count - n + 1;
        if(local <= 0) {
            return head;
        }

        else if(local == 1) {
            head = head.next;
        }

        else {
            current = head;
            int num = 1;

            boolean flag = true;
            while(flag) {

                if(local == num + 1) {
                    flag = false;
                    //删除节点
                    ListNode next = current.next;
                    ListNode targetNode = next.next;
                    current.next = targetNode;
                    next.next = null;
                }

                num ++;
                current = current.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;
}
