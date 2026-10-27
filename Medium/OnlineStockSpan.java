class StockSpanner {
private Stack<int[]> s;
    public StockSpanner() {
       s=new Stack<>();

    }
    
    public int next(int price) {
        int spn=1;
        while(!s.isEmpty() && s.peek()[0]<=price){
            spn+=s.pop()[1];
           
        }
         s.add(new int[] {price,spn});
         return spn;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
