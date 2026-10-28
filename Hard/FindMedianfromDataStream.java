class MedianFinder {
    Queue<Integer> lph; //left partition heap
    Queue<Integer> rph; //right partition heap 
    public MedianFinder() {
        lph=new PriorityQueue<>((n1,n2)->n2-n1);
        rph=new PriorityQueue<>((n1,n2)->n1-n2);
    }
    
    public void addNum(int num) {
        lph.add(num);
        rph.add(lph.poll());
        if(rph.size()>lph.size()){
            lph.add(rph.poll());
        }
    }
    
    public double findMedian() {
        if(lph.size()>rph.size()){
            return lph.peek();
        } 
        return (lph.peek()+rph.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
