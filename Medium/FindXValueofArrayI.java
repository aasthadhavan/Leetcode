class Solution {
    public long[] resultArray(int[] nums, int k) {
      long[] res=new long[k];
      long[] dp=new long[k];
      for(int n:nums){
        int rem=n%k;
        long[] nxt=new long[k];
        nxt[rem]++;

        for(int r=0;r<k;r++){
            nxt[(r*rem)%k]+=dp[r];
        }
        dp=nxt;
        for(int r=0;r<k;r++){
            res[r]+=dp[r];
        }
      } 
return res;
    }
}
