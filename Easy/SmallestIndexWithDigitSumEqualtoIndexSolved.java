class Solution {
    public int sumdig(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val=sumdig(nums[i]);
            if(val==i){
                return i;
            }
        }
       return -1;
    }
}
