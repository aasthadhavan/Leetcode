class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
           int cnt=n*2;
           HashMap<Integer,boolean[]> h=new HashMap<>();
            for(int[] s: reservedSeats){
                int row=s[0];
                int seat=s[1];
                if(seat>=2 && seat<=9){
                    h.putIfAbsent(row,new boolean[11]);
                    h.get(row)[seat]=true;
                }
            }
            cnt-=h.size()*2;
    for(boolean[] res: h.values()){
            boolean l=!res[2] && !res[3] && !res[4] && !res[5];
            boolean r=!res[6] && !res[7] && !res[8] && !res[9];
            boolean m=!res[4] && !res[5] && !res[6] && !res[7];
            if(l && r){
                cnt+=2;
            } else if ( l||m||r){
                cnt++;
            }
    }

        
return cnt;

    }
}
