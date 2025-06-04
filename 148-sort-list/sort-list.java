/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        ListNode left = head;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left,right);


    }


    public ListNode merge(ListNode left, ListNode right){
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        ListNode t1 = left;
        ListNode t2 = right;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }

        }

        if(t1 != null){
            temp.next = t1;
        }
        else{
            temp.next = t2;
        }

        dNode = dNode.next;
        return dNode;
    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}