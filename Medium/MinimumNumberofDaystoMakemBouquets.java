class Solution {
    public static boolean possible(int[] arr,int n,int m,int k){
        int cnt=0;
        int b=0;
        for(int a: arr){
            if (a<=n){
                cnt++;
                if(cnt==k){
                    b++;
                    cnt=0;
                }
            }
            else{
                cnt=0;
            }

        }
        return b>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m*k > bloomDay.length){
            return -1;
        }
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int b:bloomDay){
            mini=Math.min(mini,b);
            maxi=Math.max(maxi,b);
        }
        int l=mini;
        int h=maxi;
        int ans=-1;

        while(l<=h){
            int mid=(l+h)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                h=mid-1;
            } else{
                l=mid+1;
            }
        }

    return ans;
    }
}
