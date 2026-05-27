class Solution {
    public int maximumCount(int[] nums) {
        int maxcount=0;
        int mincount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                maxcount++;
            }
            else if(nums[i]<0){
                mincount++;
            }
        }
       if(maxcount>mincount){
        return maxcount;
       }
       else{
        return mincount;
       }
       
    }
}