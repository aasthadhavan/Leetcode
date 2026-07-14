class Solution {
    private int sumD(int[] arr,int d){
        int sum=0;
        for(int n:arr){
            sum+=Math.ceil((double)n/d);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold){
            return -1;
        }
        int l=1;
        int h=Arrays.stream(nums).max().getAsInt();
        while(l<=h){
            int mid=l+(h-l)/2;
            if(sumD(nums,mid)<=threshold){
                h=mid-1;
            } else{
                l=mid+1;
            }
        }

        return l;
    }
}
