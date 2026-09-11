class Solution {
    public int totalNumbers(int[] digits) {
        int []freq=new int[10];
        for(int d:digits){
            freq[d]++;
        }
        int cnt=0;

        for(int i=100;i<=999;i++){
            if(i%2!=0){
                continue;
            }
            int n=i;
            int a=n%10;
            n/=10;
            int b=n%10;
            n/=10;
            int c=n%10;
             
             int need[]=new int[10];
             need[a]++;
             need[b]++;
             need[c]++;

             boolean possible=true;
             for(int j=0;j<=9;j++){
                if(need[j]>freq[j]){
                    possible=false;
                    break;
                }
             }
             if(possible){
                cnt++;
             }
        }
        return cnt;
    }
}
