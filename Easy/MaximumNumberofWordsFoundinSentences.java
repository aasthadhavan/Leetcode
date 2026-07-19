class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxi=0;
        for(String s: sentences){
            int words=1;
            for(char c:s.toCharArray()){
                if(c==' ')
                {
                    words++;
                }
            }
            maxi=Math.max(maxi,words);
        }
        return maxi;
    }
}
