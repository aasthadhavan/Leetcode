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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;}

                while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;}
            
        int s=0;
        int c=0;
        ListNode ans=null;
        while(!s1.empty() || !s2.empty() || c!=0){
             s=c;
            if(!s1.empty()){
                s+=s1.pop();
            }
                if(!s2.empty()){
                s+=s2.pop();
            }
               
                c=s/10;
                ListNode n=new ListNode(s%10);
                n.next=ans;
                ans=n;
            }
                
            

        return ans;
    }
}
