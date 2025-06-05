/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int n1 = 0;
        int n2 = 0;

        while(t1 != null){
            n1++;
            t1 = t1.next;
        }

        while(t2 != null){
            n2++;
            t2 = t2.next;
        }
        t1 = headA;
        t2 = headB;
        int d = Math.abs(n2 - n1);
        if(n1 < n2){
            for(int i = 0 ; i < d ; i++){
                t2 = t2.next;
            }
        }
        else if(n1 > n2){
            for(int i = 0; i < d; i++){
                t1 = t1.next;
            }
        }

        while(t1 != null || t2 != null){
            if(t1 == t2) return t1;
            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
        
    }
}