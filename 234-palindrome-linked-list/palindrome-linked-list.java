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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder pal = new StringBuilder();
        StringBuilder rev = new StringBuilder();

        if(head == null) return false;
        if(head.next == null) return true;

        ListNode curr = head;

        while(curr != null){
            stack.push(curr.val);
            pal.append(curr.val);
            curr = curr.next;
        }
        

        while(!stack.isEmpty()){
            rev.append(stack.pop());
        }
        System.out.println("Rev is: " +rev+ " Pal is:  " +pal);
        if(pal.toString().equals(rev.toString())) return true;
        return false;


    }
}