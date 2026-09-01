class Solution {
    public class State{
        int r;
        int c;
        int e;
        int m;
        State(int r,int c,int e,int m){
            this.r=r;
            this.c=c;
            this.e=e;
            this.m=m;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        int str=0;
        int stc=0;
        int ttl=0;
        int[][] lno=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                lno[i][j]=-1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char cell=classroom[i].charAt(j);
                if(cell=='S'){
                    str=i;
                    stc=j;
                } if(cell=='L'){
                    lno[i][j]=ttl;
                    ttl++;
                }
            }
        }
        int collected=(1<<ttl)-1;
        Queue<State> q=new LinkedList<>();
        q.offer(new State(str,stc,energy,0));
        boolean [][][][] vis=new boolean[m][n][energy+1][1<<ttl];
        vis[str][stc][energy][0]=true;
        int[][] dir={
            {1,0},{-1,0},{0,1},{0,-1}
        };
        int mov=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                State curr=q.poll();
                if(curr.m==collected){
                    return mov;
                } if(curr.e==0){
                    continue;
                }
                for(int[] d:dir){
                    int newr=curr.r+d[0];
                    int newc=curr.c+d[1];
                    if(newr<0 || newr>=m || newc<0 || newc>=n){
                        continue;
                    } if(classroom[newr].charAt(newc)=='X'){
                        continue;
                    }
                    int newe=curr.e-1;
                    int newm=curr.m;
                    char cell=classroom[newr].charAt(newc);
                    if(cell=='L'){
                        int lnoatcell=lno[newr][newc];
                        newm|=(1<<lnoatcell);
                    } if(cell=='R'){
                        newe=energy;
                    } if(vis[newr][newc][newe][newm]){
                        continue;
                    }
                    vis[newr][newc][newe][newm]=true;
                    q.offer(new State(newr,newc,newe,newm));
                }
            }
            mov++;
        }
        return -1;
    }
}
