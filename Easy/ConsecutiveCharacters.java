class Solution {
    public int maxPower(String s) {
       int max=1;
       int count=1;
       for(int i=1;i<s.length();i++){
            char c= s.charAt(i);
            char p=s.charAt(i-1);
            if(c==p){
                count++;
            }
            else{
                max=Math.max(max,count);
                count=1;
            }
       }
       max=Math.max(max,count);
       return max;
    }
}