class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==')'){
                int end=i;
                int st=sb.lastIndexOf("(",end);
                String m=sb.substring(st+1,end);
                String r=new StringBuilder(m).reverse().toString();
                sb.replace(st,end+1,r);
                i-=2;
            }
        }
        return sb.toString();
    }
}
