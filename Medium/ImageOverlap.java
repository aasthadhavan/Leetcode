class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        Map<String,Integer> m=new HashMap<>();
        int overlap=0;
        for(int r1=0;r1<n;r1++){
             for(int c1=0;c1<n;c1++){
                if(img1[r1][c1]==1){
                    for(int r2=0;r2<n;r2++){
                        for(int c2=0;c2<n;c2++){
                            if(img2[r2][c2]==1){
                                int rs=r2-r1;
                                int cs=c2-c1;
                                String s=rs+","+cs;
                                int cnt=m.getOrDefault(s,0)+1;
                                 m.put(s,cnt);
                                 overlap=Math.max(overlap,cnt);

                            }
                        }
                    }
                }
             }
        }
        return overlap;
    }
    
}
