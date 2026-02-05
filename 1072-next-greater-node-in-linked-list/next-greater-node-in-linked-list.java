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
    public ListNode reverse(ListNode head){
        if(head==null)return null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev = curr;
            curr=temp;
        }
        return prev;
    }
    public int length(ListNode head){
        if(head==null)return 0;
        int l = 0;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        return l;
    }
    public int[] nextLargerNodes(ListNode head) {
        int len = length(head);  
        ListNode curr = reverse(head);
        Stack<Integer>st = new Stack<>();
        int z=len-1;
        int[] ans = new int[len];
        while(curr!=null){
            while(!st.isEmpty() && st.peek()<=curr.val){
                st.pop();
            }
            ans[z--] = st.isEmpty() ? 0 : st.peek();
            st.push(curr.val);

            curr = curr.next;
        }
        return ans;
    }
}