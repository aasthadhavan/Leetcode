class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] ns=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ns[i]=nums[i];

        }
        Arrays.sort(ns);
        int currg=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(ns[0],currg);
        HashMap<Integer,LinkedList<Integer>> g=new HashMap<>();
        g.put(currg,new LinkedList<Integer>(Arrays.asList(ns[0])));
        for(int i=1;i<nums.length;i++){
            if(Math.abs(ns[i]-ns[i-1])>limit){
                currg++;
            }
            h.put(ns[i],currg);
            if(!g.containsKey(currg)){
                g.put(currg,new LinkedList<Integer>());
            }
            g.get(currg).add(ns[i]);

        }
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int grp=h.get(n);
            nums[i]=g.get(grp).pop();
        }
        return nums;
    }
}
