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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=null, curr=head;
        ArrayList<Integer> l=new ArrayList<>();
        int[] res={-1,-1};
        int i=1;
        while(curr.next!=null){
            if(prev==null){
                prev=curr;
                curr=curr.next;
                i++;
                continue;
            }
            if(prev.val<curr.val && curr.val>curr.next.val){
                l.add(i);    
            }
            if(prev.val>curr.val && curr.val<curr.next.val){
                l.add(i);
            }
            prev=curr;
                curr=curr.next;
                i++;
        }

        if(l.size()>=2){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<l.size();j++){
                int dis=l.get(j)-l.get(j-1);
                if(dis<min){
                    min=dis;
                }
            }
            res[0]=min;
            res[1]=l.get(l.size()-1)-l.get(0);
        }

        return res;
    }
}
