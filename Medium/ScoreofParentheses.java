class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(0);
            } else{
                if(st.peek()==0){
                    st.pop();
                    st.push(1);
                } else{
                    int sum=0;
                    while(st.peek()!=0){
                        sum+=st.pop();
                    }
                    st.pop();
                    st.push(2*sum);
                }
            }

        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}
