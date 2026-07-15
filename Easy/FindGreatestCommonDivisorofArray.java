class Solution {
    

    public int findGCD(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int n:nums){
            mini=Math.min(mini,n);
            maxi=Math.max(maxi,n);
        }
        return gcd(maxi,mini);
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        } 
          return gcd(b,a%b);
}
    }
