class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        int term1=0;
        int term2=1;
       
            for
            (int i=1;i<=n;i++){
                int term3= term1+term2;
                term1=term2;
                term2=term3;
    }
    return term1;
}

}