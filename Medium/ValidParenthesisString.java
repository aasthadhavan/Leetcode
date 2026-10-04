class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> l,star;
        l=new Stack<>();
        star=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') l.push(i);
            else if(s.charAt(i)=='*') star.push(i);
            else{
                if(!l.isEmpty()) l.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }
        while(l.size()!=0){
            if(star.size()==0){
                return false;
            } if(star.peek()>l.peek()){
                star.pop();
                l.pop();
            } else{
                return false;
            }
        }
        return true;
    }
}
