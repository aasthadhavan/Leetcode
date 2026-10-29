class Solution {
    public int maxVowels(String s, int k) {
        int l=0;
        int r=0;
        int wdw=0;
        int res=0;
        for(;r<k;r++){
            wdw+=isVowel(s.charAt(r));
        }
        res=wdw;
        while(r<s.length()){
            wdw-=isVowel(s.charAt(l++));
            wdw+=isVowel(s.charAt(r++));
            res=Math.max(res,wdw);
        }
        return res;
    }
    private int isVowel(char c){
        return (c=='a'|| c=='e' || c=='i'|| c=='o' || c=='u')?1:0;
    }
}
