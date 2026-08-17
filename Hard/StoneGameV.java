class Solution {
     int [][]dp=new int[501][501];
        int help(int s,int e,int[] stoneValue){
            if(s>=e) return 0;
            if(dp[s][e]!=-1) return dp[s][e];
            int r=0;
            for(int i=s;i<=e;i++){
                r+=stoneValue[i];
            }
            int l=0;
            int ans=0;
            for(int i=s;i<e;i++){
                l+=stoneValue[i];
                r-=stoneValue[i];

            if (l < r) {
                ans = Math.max(ans, l + help(s, i, stoneValue));
            }
                if(l==r){
                    ans=Math.max(ans,Math.max(l+help(s,i,stoneValue),r+help(i+1,e,stoneValue)));
                }

                if(r<l){
                    ans=Math.max(ans,r+help(i+1,e,stoneValue));
                }
            }
            return dp[s][e]=ans;
        }
    public int stoneGameV(int[] stoneValue) {
       for(int[] n:dp){
        java.util.Arrays.fill(n,-1);
       }
       return help(0,stoneValue.length-1,stoneValue);
    }
}
