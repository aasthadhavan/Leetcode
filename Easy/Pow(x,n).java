class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        long N=n;
        boolean neg = N < 0;
        
        if(neg){
            N = -N;
        }

        double res=1;   
        double currp=x;
        while(N>0){
            if(N%2==1){
                res*=currp;
            }
            currp*=currp; //sq base
            N/=2; //divide expo

        }
        return neg?1/res:res;
    }
}
