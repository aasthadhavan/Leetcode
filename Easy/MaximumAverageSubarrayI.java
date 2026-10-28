class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxs=0;
        int currs=0;
        for(int i=0;i<k;i++){
            currs+=nums[i];
        }
        maxs=currs;
        for(int i=k;i<nums.length;i++){
            currs=currs+nums[i]-nums[i-k];
            if(currs>maxs){
                maxs=currs;
            }
        }
        return (double)maxs/k;
    }
}
