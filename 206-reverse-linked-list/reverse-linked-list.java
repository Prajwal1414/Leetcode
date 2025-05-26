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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> st = new Stack<>();

        if(head == null || head.next == null) return head;

        ListNode node = head;
        while(node != null){
            st.push(node.val);
            node = node.next;
        }


        ListNode newHead = new ListNode(st.pop());
        System.out.println(newHead.val);
        node = newHead;
        int n = st.size();
        for(int i = 0 ; i < n; i++){
            node.next = new ListNode(st.pop());
            node = node.next;
            System.out.println(node.val);
        }

        return newHead;
    }
}