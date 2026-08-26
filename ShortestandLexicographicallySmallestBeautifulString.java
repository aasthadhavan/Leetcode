class Solution {
     int j=0;
        int len=0;
        String res="";
        int maxi=Integer.MAX_VALUE;
        
    public String shortestBeautifulSubstring(String s, int k) {
       for(int i=0;i<s.length();i++){
        int val=s.charAt(i)-'0';
        if(val==1){
            len++;
        }
        if(len==k){
            trimm(s);
            if(i-j<maxi){
                maxi=i-j;
                res=s.substring(j,i+1);
                            }
            if(i-j==maxi){
                res=lexsmall(res,s.substring(j,i+1));
            }
            j++;
            len--;
        }
       }
       return res;
    }

    public void trimm(String s){
        while(j<s.length()){
            int val=s.charAt(j)-'0';
            if(val==1){
                return;
            }
            j++;
        }
    }

    public String lexsmall(String s1,String s2){
        if(s1.compareTo(s2)<0){
            return s1;
        } else{
            return s2;
        }
    }
}
