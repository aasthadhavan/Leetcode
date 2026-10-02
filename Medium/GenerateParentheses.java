class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<>();
        gen(res,"",n,n);
        return res;
    }

    void gen(List<String> res,String s,int l,int r){
        if(l==0 && r==0){
            res.add(s);
            return;
        } if(l>0){
            gen(res,s+"(",l-1,r);
        } if(r>l){
            gen(res,s+")",l,r-1);
        }
    }
}
