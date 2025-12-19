
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        int cnt = 0;
        ListNode curr = head;
        while(curr != null && cnt <k){
            curr = curr.next;
            cnt++;
        }

        if(cnt < k) return head;

        ListNode prev = null;
        curr = head;
        ListNode next;
        for(int i=0; i<k; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
