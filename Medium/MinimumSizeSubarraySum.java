class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int wdw=0,ans=n+1,l=0;
        for(int r=0;r<n;r++){
            wdw+=nums[r];
            while(wdw>=target){
            ans=Math.min(ans,r-l+1);
            wdw-=nums[l++];
            }
        }

        return ans==n+1?0:ans;
    }
}
