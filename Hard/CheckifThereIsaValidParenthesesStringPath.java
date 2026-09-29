class Solution {
    int m,n;
    char[][] grid;
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
          if ((m+n-1)%2!=0) return false;
        memo=new Boolean[m][n][m+n+1];
        int bal=grid[0][0]=='('?1:-1;
        return dfs(0,0,bal);
        
    }

    private boolean dfs(int i,int j,int bal){
        if(bal<0){
            return false;
        }
          if(bal > (m-1-i)+(n-1-j)){
            return false;
        }
         if(i==m-1 && j==n-1){
            return bal==0;
        }
        if(memo[i][j][bal]!=null){
            return memo[i][j][bal];
        } if(i+1<m){
            int newb=bal+(grid[i+1][j]=='('?1:-1);
            if(dfs(i+1,j,newb)){
                return memo[i][j][bal]=true;
            }
        } if(j+1<n){
            int newb=bal+(grid[i][j+1]=='('?1:-1);
            if(dfs(i,j+1,newb)){
                return memo[i][j][bal]=true;
            }
        }
           return memo[i][j][bal]=false;
    }
}
