class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int []ans=new int[seq.length()];
        int dep=0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                dep++;
                ans[i]=dep%2;

            } else{
                ans[i]=dep%2;
                dep--;
            }
        }
return ans;
    }
}
