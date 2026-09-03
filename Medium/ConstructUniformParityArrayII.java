class Solution {
    public boolean uniformArray(int[] nums1) {
        int minodd=Integer.MAX_VALUE;
        for(int n:nums1){
            if(n%2!=0){
                minodd=Math.min(minodd,n);
            }
        }
        if(minodd==Integer.MAX_VALUE) return true;
        for(int n:nums1){
            if(n%2==0 && n<=minodd){
                return false;
            }
        }
        return true;
    }
}
