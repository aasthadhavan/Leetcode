class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> res=new HashSet<>();
        Deque<String> q=new ArrayDeque<>();
        q.offer(expression);
        while(!q.isEmpty()){
            String cur=q.poll();
            if(cur.indexOf("{")==-1){
                res.add(cur);
                continue;
            }
            int l=cur.indexOf("{");
            int idx=l;
            while(idx<cur.length() && cur.charAt(idx)!='}'){
                if(cur.charAt(idx)=='{'){
                    l=idx;
                } 
                idx++;
            }
            int r=idx;
            String proc=cur.substring(0,l);
            String[] procsng=cur.substring(l+1,r).split(",");
            String unproc=cur.substring(r+1);
    for(String p:procsng){
        StringBuilder sb=new StringBuilder(proc);
        sb.append(p).append(unproc);
        q.offer(sb.toString());
    }
        }
        List<String> rl=new ArrayList<>(res);
        Collections.sort(rl);
        return rl;
    }
}
