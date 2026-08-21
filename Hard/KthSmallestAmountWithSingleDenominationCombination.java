class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l=1;
        long h=Long.MAX_VALUE;
        for(int i:coins){
            h=Math.min(h,(long)i*k);
        }
        while(l<h){
            long m=l+(h-l)/2;
            if(count(m,coins)>=k){
                h=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    private long count(long x,int[] coins){
        int n=coins.length;
        long c=0;
        for(int m=1;m<(1<<n);m++){
            long lcm=1;
            int bits=0;
            boolean val=true;
            for(int j=0;j<n;j++){
                if((m & (1<<j))!=0){
                    bits++;
                    lcm=lcm(lcm,coins[j]);
                    if(lcm>x){
                        val=false;
                        break;
                    }
                }
            }
            if(!val) continue;
            long mul=x/lcm;
            if(bits%2==1){
                c+=mul;
            } else{
                c-=mul;
            }
        }
         return c;
    }
    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }
   
}
