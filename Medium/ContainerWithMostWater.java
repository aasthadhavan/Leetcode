class Solution {
    public int maxArea(int[] height) {
        int s=0;
        int e=height.length-1;
        int maxcap=0;
        while(s<e){
            int h=Math.min(height[s],height[e]);
            int width=e-s;
            int currcap=h*width;
            maxcap= Math.max(currcap,maxcap);
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return maxcap;
    }
}