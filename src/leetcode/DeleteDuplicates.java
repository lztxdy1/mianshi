package leetcode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(2);
        ListNode h4= new ListNode(3);
        ListNode h5 = new ListNode(4);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = null;

        ListNode res = deleteDuplicates(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0, head);
        ListNode q = p;
        while(q.next != null && q.next.next != null){
            if (q.next.val == q.next.next.val){
               int temp = q.next.val;
               while (q.next != null && q.next.val == temp){
                    q.next = q.next.next;
               }
            }else {
                q = q.next;
            }

        }
        return p.next;
    }
}
