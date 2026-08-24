class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        // add first node of list to pq
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            // get the smallest node
            ListNode node=pq.poll();

            // add it to result
            temp.next=node;
            temp=temp.next;

            // add next node from same list
            if(node.next!=null){
                pq.add(node.next);
                            }
        }
        return dummy.next;

        
    }
}