class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int m:nums){
            ans^=m;
        } if(ans!=0){
            return n;
        }
        for(int j:nums){
            if(j!=0){
                return n-1;
            }
        }
        return 0;
    }
}
