class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] best=new int[n];
        Arrays.fill(best,Integer.MAX_VALUE);
        int l=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            while(sum>target){
                sum-=arr[l++];
            }
            if(sum==target){
                int currl=r-l+1;
                if(l>0 && best[l-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,currl+best[l-1]);
                }
                if(r==0){
                    best[r]=currl;
                } else{
                    best[r]=Math.min(best[r-1],currl);
                }
            }
            else if(r>0){
                best[r]=best[r-1];
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
