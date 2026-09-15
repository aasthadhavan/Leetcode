class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        int st=0;
        int ans=0;
        for(int r=k-1;r<n;r++){
            for(int len=k;len<=r-st+1;len++){
                int l=r-len+1;
                if(check(s,l,r)){
                    ans++;
                    st=r+1;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean check(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
