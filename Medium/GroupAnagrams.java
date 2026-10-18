class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> m=new HashMap<>();
        for(String s:strs){
            int[] cnt=new int[26];
            for(char c:s.toCharArray()){
                cnt[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i:cnt){
                sb.append("#");
                sb.append(i);
            }
            String k=sb.toString();
            if(!m.containsKey(k)){
                m.put(k,new ArrayList<String>());
            }
            m.get(k).add(s);
        }
        return new ArrayList(m.values());
    }
}
