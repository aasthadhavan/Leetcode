class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int cnt[]=new int[26];
        int fi[]=new int[26];
        int li[]=new int[26];
        Arrays.fill(fi,-1);
        Arrays.fill(li,-1);
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(cnt[c]==0){
                fi[c]=i;
                l.add(c);
            }
            cnt[c]++;
            li[c]=i;
        }
        List<String> res=new ArrayList<>();
        Deque <int[]> q=new ArrayDeque<>();
        for(int c:l){
            q.addFirst(new int[]{
                fi[c],li[c],cnt[c]
            });

            int lf=Integer.MAX_VALUE;
            int r=Integer.MIN_VALUE;
            int ttl=0;
            for(int[] i:q){
                ttl+=i[2];
                lf=Math.min(lf,i[0]);
                r=Math.max(r,i[1]);
                if(ttl==r-lf+1){
                    break;
                }
            }

            if(ttl==r-lf+1){
                res.add(s.substring(lf,r+1));
                q.clear();
            }
        }
        return res;
    }
}
