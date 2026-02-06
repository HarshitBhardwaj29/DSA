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
    public ListNode mergeKLists(ListNode[] lists) {
    ArrayList<ListNode> list = new ArrayList<>();

    for (ListNode node : lists) {
        while (node != null) {
            list.add(node);
            node = node.next;
        }
    }
    Collections.sort(list, (a, b) -> a.val - b.val);

    ListNode dummy = new ListNode(0);
    ListNode temp = dummy;

    for (ListNode node : list) {
        temp.next = new ListNode(node.val);
        temp = temp.next;
    }

    return dummy.next;
}

}