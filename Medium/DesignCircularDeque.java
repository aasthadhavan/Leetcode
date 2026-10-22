class MyCircularDeque {
 Deque<Integer> d; 
 int cap;
    public MyCircularDeque(int k) {
        d=new ArrayDeque<>();
        cap=k;
    }
    
    public boolean insertFront(int value) {
        if(d.size()<cap){
            return d.offerFirst(value);
        } else{
            return false;
        }
    }
    
    public boolean insertLast(int value) {
        if(d.size()<cap){
            return d.offerLast(value);
        } else{
            return false;
        }
    }
    
    public boolean deleteFront() {
        if(!d.isEmpty()){
            d.pollFirst();
            return true;
        } else{
            return false;
        }
    }
    
    public boolean deleteLast() {
        if(!d.isEmpty()){
            d.pollLast();
            return true;
        } else{
            return false;
        }
    }
    
    public int getFront() {
         if(!d.isEmpty()){
           return d.peekFirst();
        } else{
            return -1;
        }
    }
    
    public int getRear() {
         if(!d.isEmpty()){
           return d.peekLast();
        } else{
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return d.isEmpty();
    }
    
    public boolean isFull() {
        return d.size()==cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
