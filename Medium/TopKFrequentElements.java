class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry j:m.entrySet()){
            pq.add(j);
        }

        int[] op=new int[k];
        for(int i=0;i<k;i++){
            op[i]=pq.poll().getKey();
        }

        return op;
    }
}
