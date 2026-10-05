class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int sum=nums[0];
        int max=nums[0];
        int maxh=nums[0];
        int min=nums[0];
        int minh=nums[0];

        for(int i=1;i<nums.length;i++){
            int n=nums[i];
            sum=sum+n;
            maxh=Math.max(n,maxh+n);
            max=Math.max(maxh,max);
            minh=Math.min(n,minh+n);
            min=Math.min(min,minh);
            
        }
        if(sum==min){
            return max;
        }
        return Math.max(sum-min,max);
        }
    }
