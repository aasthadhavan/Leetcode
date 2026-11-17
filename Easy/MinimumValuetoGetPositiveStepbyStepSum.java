class Solution {
    public int minStartValue(int[] nums) {
        int sum=0,min=0;
        for(int n:nums){
            sum+=n;
            min=Math.min(sum,min);
        }

        return 1-min;
    }
}
