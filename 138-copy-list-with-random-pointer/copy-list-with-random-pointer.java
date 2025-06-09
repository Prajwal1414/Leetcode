/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node dNode = new Node(-1);
        Node temp = head;

        while(temp != null){
            Node inBw = new Node(temp.val);
            inBw.next = temp.next;
            temp.next = inBw;

            temp = temp.next.next;
        }

        temp = head;

        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
               copyNode.random = null; 
            }
            temp = temp.next.next;
        }

        Node res = dNode;
        temp = head;

        while(temp != null){
           Node copyNode = temp.next;
           temp.next = copyNode.next;
           res.next = copyNode;
           res = copyNode;
            temp = temp.next;
        }
        return dNode.next;
    }
}