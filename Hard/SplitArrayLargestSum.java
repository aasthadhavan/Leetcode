class Solution {
    public int countp(int[] a,int msum){
        int p=1;
        int subsum=0;
        for(int n:a){
            if(subsum+n<=msum){
                subsum+=n;
            } else{
                p++;
                subsum=n;
            }
        }
        return p;
    }
    public int splitArray(int[] nums, int k) {
        int l=Arrays.stream(nums).max().getAsInt();
        int h=Arrays.stream(nums).sum();
        while(l<=h){
            int mid=(l+h)/2;
            int p=countp(nums,mid);
            if(p>k){
                l=mid+1;
            } else{
                h=mid-1;
            }
        }
        return l;
    }
}
