class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevGrp=null;
        ListNode newHead=null;
        while(head!=null){
            ListNode kth=head;
            for(int i=0;i<k;i++){
                if(kth==null){
                    return newHead;
                }
                kth=kth.next;
            }
            ListNode nextGrp=kth;
            ListNode prev=nextGrp;
            ListNode curr=head;
            while(curr!=nextGrp){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            if(prevGrp==null){
                newHead=prev;
            }else{
                prevGrp.next=prev;
            }
            prevGrp=head;
            head=nextGrp;

        }
        return newHead;

        
    }
}