class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String o:operations){
            if(o.contains("++")){
                x++;
            } else{
                x--;
            }
        }
    return x;
    }
}
