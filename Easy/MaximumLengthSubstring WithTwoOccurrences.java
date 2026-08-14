class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> m=new HashMap<>();
        int maxl=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            m.put(s.charAt(r),m.getOrDefault(s.charAt(r),0)+1);
            while(m.get(s.charAt(r))>2){
                int lval=m.get(s.charAt(l))-1;
                m.put(s.charAt(l),lval);
                if(m.get(s.charAt(l))==0){
                    m.remove(s.charAt(l));
                }
                l++;
            }
            maxl=Math.max(maxl,r-l+1);
        }
        return maxl;
    }
}
