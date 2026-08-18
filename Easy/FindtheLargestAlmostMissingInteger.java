class Solution {
    public int largestInteger(int[] nums, int k) {
        int cnt[]=new int[51];
        for(int i=0;i<=nums.length-k;i++){
            boolean[] seen=new boolean[51];
            for(int j=i;j<i+k;j++){
                seen[nums[j]]=true;
            }

            for(int x=0;x<=50;x++){
                if(seen[x]){
                    cnt[x]++;
                }
            }
        }
        for(int z=50;z>=0;z--){
            if(cnt[z]==1){
                return z;
            }
        }
        return -1;
    }
}
