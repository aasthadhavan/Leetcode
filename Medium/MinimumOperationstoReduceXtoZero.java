class Solution {
    public int minOperations(int[] nums, int x) {
        int target=-x; 
        for(int i:nums) target+=i;
        if(target==0) return nums.length;
        if(target<0) return -1;
        int l=0;
        int sum=0;
        int res=-1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>target){
                sum-=nums[l];
                l++;
            } if(sum==target){
                res=Math.max(res,i-l+1);
            }
        }

return res==-1?-1:nums.length-res;
    }
}
