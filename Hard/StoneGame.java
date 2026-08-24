class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        for(int i=1;i<n;i++){
            stones[i]+=stones[i-1];
        }
        int best=stones[n-1];
        for(int j=n-2;j>=1;j--){
            best=Math.max(best,stones[j]-best);
        }
        return best;
    }
}
