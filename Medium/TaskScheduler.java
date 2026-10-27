class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt=new int[26];
        for(int i=0;i<tasks.length;i++){
            cnt[tasks[i]-'A']++;
        }
        Arrays.sort(cnt);
        int max=cnt[25];
        int idle=(max-1)*n;
        for(int i=24;i>=0;i--){
            idle-=Math.min(cnt[i],max-1);
        }
        idle=Math.max(idle,0);
        return tasks.length+idle;
    }
}
