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

        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null ){
            list.add(temp.val);
            temp = temp.next;
        }

        System.out.println(list);

        Collections.sort(list);
        temp = head;
        for(int i = 0 ; i < list.size(); i++){
            temp.val = list.get(i);
            temp = temp.next;
        }

        return head;
    }
}