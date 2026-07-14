class Solution {
    private int ship(int[] a, int c){
        int d=1;
        int currload=0;
        for(int w:a){
            if(currload+w>c){
                d++;
                currload=w;
            } else{
                currload+=w;
            }
        }
        return d;
    }
    private int sum(int[] weights){
        int s=0;
        for(int n:weights){
            s+=n;
        }
        return s;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l=Arrays.stream(weights).max().getAsInt();
        int h=sum(weights);
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            int noofdays=ship(weights,mid);
            if(noofdays<=days){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}
