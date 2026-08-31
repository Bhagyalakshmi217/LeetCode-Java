class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevGrp=null;
        ListNode newHead=null;
        while(head!=null){
            // find the kth node
            ListNode kth=head;
            for(int i=0;i<k;i++){
                if(kth==null){
                    return newHead;
                }
                kth=kth.next;
            }

            // kth=first node of next grp
            ListNode nextGrp=kth;

            // Reverse the k nodes
            ListNode prev=nextGrp;
            ListNode curr=head;
            while(curr!=nextGrp){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            // connects the prev group
            if(prevGrp==null){
                newHead=prev;
            }else{
                prevGrp.next=prev;
            }
            // old head is now tail
            prevGrp=head;

            // move to next group
            head=nextGrp;

        }
        return newHead;        
    }
}

// head
//  ↓
// Find kth
//  ↓
// Enough k nodes?
//  ├── NO → stop
//  │
//  └── YES
//        ↓
//    save next group
//        ↓
//    reverse k nodes
//        ↓
//    connect previous group
//        ↓
//    connect old head → next group
//        ↓
//    move groupPrev
//        ↓
//    move head
//        ↓
//      repeat


// head       → beginning of current group
// kth        → boundary of current group
// nextGroup  → where next group starts
// prev       → reversed part
// curr       → node currently being reversed
// next       → saved next node