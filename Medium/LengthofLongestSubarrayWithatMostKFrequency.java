class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        int currl=0;
        int maxl=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            m.put(nums[r],m.getOrDefault(nums[r],0)+1);
            while(m.get(nums[r])>k){
                m.put(nums[l],m.get(nums[l])-1);
                l++;
            }
            currl=r-l+1;
            maxl=Math.max(maxl,currl);
        }
        return maxl;
    }
}
