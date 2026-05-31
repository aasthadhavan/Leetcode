//SpiralMatrix II
class Solution {
    public int[][] generateMatrix(int n) {
        int [][]arr=new int[n][n];
        int count=1;
        int minc=0;
        int minr=0;;
        int maxr=n-1;
        int maxc=n-1;
        while(count<=n*n){
        for(int c=minc;c<=maxc;c++){
            arr[minr][c]=count;
            count++;
        }
        for(int r=minr+1;r<=maxr;r++){
            arr[r][maxc]=count;
            count++;
        }
        //maxr is fixed, col changes
        for(int c=maxc-1;c>=minc;c--){
            arr[maxr][c]=count;
            count++;
        }

        for(int r=maxr-1;r>=minr+1;r--){
            arr[r][minc]=count;
            count++;
        }
        minc++;
        maxc--;
        minr++;
        maxr--;
        }

        return arr;
    }
}
