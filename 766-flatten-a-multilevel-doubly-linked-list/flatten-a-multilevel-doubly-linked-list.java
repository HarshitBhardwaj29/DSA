/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)return null;
        Node curr = head;
        Stack<Node> st = new Stack<>();
        while(curr!=null){
            if(curr.child!=null){
                if (curr.next != null) {
                    st.push(curr.next);
                }
                curr.next=curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            else if(curr.next == null && !st.isEmpty()){
                Node temp=st.pop();
                curr.next=temp;
                temp.prev=curr;
            }
            curr=curr.next;
        } 
        return head;
    }
}