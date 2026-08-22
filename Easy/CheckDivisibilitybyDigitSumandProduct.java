class Solution {
    public boolean checkDivisibility(int n) {
        int og=n;
        int sum=0;
        int prod=1;
        while(n!=0){
            int ld=n%10;
            sum+=ld;
            prod*=ld;
            n=n/10;
        }
        int c=sum+prod;
        return (og%c)==0;
    }
}
