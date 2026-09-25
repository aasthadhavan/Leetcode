class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int []ans=new int[m*n];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                i++;
            } else if(nums1[i]>nums2[j]){
                j++;
            }
            else {
                ans[k++]=nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(ans,0,k);
    }
}
