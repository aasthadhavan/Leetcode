class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [] maxa=new int[n];
        maxa[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxa[i]=Math.max(maxa[i+1],prices[i]);
        }

        int ans=0;
        for(int i=0;i<prices.length;i++){
            int currp=maxa[i]-prices[i];
            ans=Math.max(ans,currp);
        }
        return ans;
    }
}