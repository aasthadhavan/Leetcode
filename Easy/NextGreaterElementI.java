class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> ng=new HashMap<>();
        Stack<Integer> s=new Stack<>();
        for(int n:nums2){
            while(!s.isEmpty() && s.peek()<n){
                ng.put(s.pop(),n);
            }
            s.push(n);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=ng.getOrDefault(nums1[i],-1);
        }

        return nums1;
    }
}
