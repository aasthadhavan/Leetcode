class Solution {
    public String truncateSentence(String s, int k) {
        String[] w=s.split(" ");
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<k;i++){
            if(i>0){
                ans.append(" ");
            }
            ans.append(w[i]);
        }
        return ans.toString();
    }
}
