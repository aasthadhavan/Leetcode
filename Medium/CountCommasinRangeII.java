class Solution {
    public long countCommas(long n) {
        long comma=0;
        long thresh=1000;
        while(thresh<=n){
            comma+=n-thresh+1;
            thresh*=1000;
        }
        return comma;
    }
}
