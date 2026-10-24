class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s=new Stack<>();
        for(String o:operations){
            switch(o){
                case "+":
                    int last=s.pop();
                    int seclast=s.peek();
                    s.push(last);
                    s.push(last+seclast);
                    break;

                case "D":
                    s.push(2*s.peek());
                    break;

                case "C":
                    s.pop();
                    break;

                default:
                    s.push(Integer.parseInt(o));
                    break;
            }
        }
        int sum=0;
        for(int i:s){
            sum+=i;
        }
        return sum;
    }
}
