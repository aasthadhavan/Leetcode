class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int diff=0;
        int qdiff=0;
        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?'){
                qdiff++;
            } else{
                diff+=num.charAt(i)-'0';
            }
        } 

                for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?'){
                qdiff--;
            } else{
                diff-=num.charAt(i)-'0';
            }
        }

        if(qdiff==0){
            return diff!=0;
        }
        return diff*2!= -9*qdiff;
    }
}
