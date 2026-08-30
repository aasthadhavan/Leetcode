class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mini=0;
        int maxi=0;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[mini]){
                mini=i;
            }
            if(nums[i]>nums[maxi]){
                maxi=i;
            }
        }
        int l=Math.max(mini,maxi)+1;
        int r=n-Math.min(mini,maxi);
        int b=Math.min(mini,maxi)+1+ n-Math.max(mini,maxi);

        return Math.min(l,Math.min(r,b));
    }
}
