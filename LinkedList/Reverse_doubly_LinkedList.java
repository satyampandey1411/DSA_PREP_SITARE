
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        DLLNode curr = head;
        DLLNode prev = null;
        
        while(curr != null){
            DLLNode next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
